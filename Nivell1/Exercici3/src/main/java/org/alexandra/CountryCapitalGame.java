package org.alexandra;

import java.io.*;
import java.util.*;

public class CountryCapitalGame {

    private Scanner scanner;
    private String userName;
    private int score;
    private String scoreFilePath = "src/main/resources/classificacio.txt";

    public CountryCapitalGame() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CountryCapitalGame game = new CountryCapitalGame();

        HashMap<String,String> countryCapitalList = game.loadFile();

        game.userName = game.askUserName();

        game.score = game.playGame(countryCapitalList);

        game.saveScoreInFile(game.scoreFilePath, game.userName, game.score);
    }

    public int playGame(HashMap<String,String> countryCapitalList) {
        String capital;

        List<String> countries = new ArrayList<>(countryCapitalList.keySet());
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = rand.nextInt(countries.size());
            String country = countries.remove(randomIndex);
            System.out.println("Enter the capital of " + country + ":");
            capital = scanner.nextLine();
            if(countryCapitalList.get(country).equalsIgnoreCase(capital)) {
                this.score += 1;
            }
        }
        scanner.close();
        System.out.println("Total score: "+ this.score);
        return this.score;
    }

    public String askUserName() {
        System.out.println("Enter your name:");
        return this.scanner.nextLine();
    }

    public void saveScoreInFile(String filePath, String userName, int score){
        String userScore = userName + " " + score;
        File file = new File(filePath);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                bw.write(userScore);
                bw.newLine();
                System.out.println("Saved score: " + userScore + " to " + filePath);
            }
        } catch (IOException e) {
            System.out.println("Error while saving score");
            System.exit(1);
        }
    }

    public HashMap<String,String> loadFile(){
        HashMap<String,String> countryCapital = new HashMap<>();
        InputStream countriesFile = CountryCapitalGame.class.getClassLoader().getResourceAsStream("countries.txt");

        if (countriesFile == null) {
            System.out.println("countries.txt file not found");
            System.exit(1);
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(countriesFile));
            String line;
            while ((line = br.readLine()) != null){
                line = line.trim();
                if(line.isEmpty()){
                    continue;
                }
                String[] pair = line.split(" ");

                for (int i = 0; i < pair.length; i++) {
                    pair[i] = pair[i].replace("_", " ");
                }
                countryCapital.put(pair[0],pair[1]);
            }
        } catch (IOException e) {
            System.out.println("Could not read countries.txt file");
            System.exit(1);;
        }
        return countryCapital;
    }
}