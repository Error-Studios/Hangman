// Holden Briggs
//
//

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String word = "pizza";
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int incorrectGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }
        System.out.println("*******************");
        System.out.println("Welcome to Hangman!");
        System.out.println("*******************");

        while (incorrectGuesses < 6) {

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
                        System.out.println("The word was" + word);
                        break;

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
        }
        scanner.close();
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









