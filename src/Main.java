// Holden Briggs
// The purpose of the code is too
//
 // Credits to Bro Code on YouTube for much of the code


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String filePath = "src/words.txt";
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find file");
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }

        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int incorrectGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }
        System.out.println("*******************");
        System.out.println("Welcome to Hangman!");
        System.out.println("*******************");
        int wins = 0;
        int losses = 0;

        boolean gameOn = true;

        while (gameOn == true) {
            System.out.print(getHangmanArt(incorrectGuesses));

            System.out.print("Word: ");

            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct guess!\n");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }

                    if(!wordState.contains('_')){
                        System.out.println(getHangmanArt(incorrectGuesses));
                        System.out.println("YOU WIN!");
                        System.out.println("The word was " + word);
                        wins ++;
                        gameOn = false;

                    }
                }
            } else {
                incorrectGuesses++;
                System.out.println("Wrong guess!\n");
            }
        }

        if (incorrectGuesses >= 6) {
            System.out.print(getHangmanArt(incorrectGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was: " + word);
            losses ++;
            gameOn = false;

        }
        while (!gameOn) {
            incorrectGuesses = 0;
            System.out.println("Do you want to play again?");
            String playAgain = scanner.next().toLowerCase();
            if (playAgain.equals("yes")) {
                gameOn = true;

            } else if (playAgain.equals("no")) {
                System.out.println("You have " + wins + "wins!" );
                System.out.println("You have " + losses + "losses!");
                System.out.println("Thanks for playing!");
                break;
            }
            else {
                System.out.println("Not a valid response, try again.");
            }
        }
    }



    static String getHangmanArt(int incorrectGuesses) {

        if (incorrectGuesses == 0) {
            System.out.println("---------");
            System.out.println("||   |   ");
            System.out.println("||       ");
            System.out.println("||       ");
            System.out.println("||       ");

        } else if (incorrectGuesses == 1) {
            System.out.println("---------");
            System.out.println("||   |   ");
            System.out.println("||   0   ");
            System.out.println("||       ");
            System.out.println("||       ");

        } else if (incorrectGuesses == 2) {
            System.out.println("---------");
            System.out.println("||   |   ");
            System.out.println("||   0   ");
            System.out.println("||   |   ");
            System.out.println("||       ");

        } else if (incorrectGuesses == 3) {
            System.out.println("---------");
            System.out.println("||   |   ");
            System.out.println("||   0   ");
            System.out.println("|| / |   ");
            System.out.println("||       ");

        } else if (incorrectGuesses == 4) {
            System.out.println("---------");
            System.out.println("||   |   ");
            System.out.println("||   0   ");
            System.out.println("|| / | \\");
            System.out.println("||       ");

        } else if (incorrectGuesses == 5) {
            System.out.println("---------");
            System.out.println("||   |   ");
            System.out.println("||   0   ");
            System.out.println("|| / | \\");
            System.out.println("||  /    ");
        } else if (incorrectGuesses == 6) {
            System.out.println("---------");
            System.out.println("||   |   ");
            System.out.println("||   0   ");
            System.out.println("|| / | \\");
            System.out.println("||  / \\ ");
        }
        return "";
    }
}