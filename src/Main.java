import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean play = true;

        while (play) {
            play = playGame();
        }
    }

    private static boolean playGame() {
        Game newGame = new Game(createDeck());
        Scanner scanner = new Scanner(System.in);

        newGame.playerDraw();
        boolean stand = false;
        while (newGame.calculatePlayer() < 22) {
            System.out.println("\nYour current sum of cards is " + newGame.calculatePlayer());
            System.out.println("\nDo you want to hit or stand? ");
            String input = scanner.nextLine();

            if (input.toLowerCase().equals("hit")) {
                newGame.playerDraw();
            } else {
                stand = true;
                break;
            }
        }
        if (!stand) {
            System.out.println("\nYou went bust!");
        }
        newGame.endStep();
        System.out.println("Would you like to play again?");
        String playAgain = scanner.nextLine();
        return playAgain.toLowerCase().equals("yes");
    }

    private static List<Card> createDeck() {

        List<Card> deck = new ArrayList<>();

        for (int suitNum = 0; suitNum < 3; suitNum++) {
            for (int value = 1; value < 14; value++) {
                deck.add(new Card(suitNum, value));
            }
        }

        Collections.shuffle(deck);
        return deck;
    }
}