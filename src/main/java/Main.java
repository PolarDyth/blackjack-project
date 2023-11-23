import PlayingCard.Card;
import PlayingCard.CardSuit;
import PlayingCard.CardValue;

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

//            while (!(input.equalsIgnoreCase("hit") || input.equalsIgnoreCase("stand"))) {
//                System.out.println("Please enter 'hit' or 'stand'");
//                input = scanner.nextLine();
//            }

            if (input.equalsIgnoreCase("hit")) {
                newGame.playerDraw();
            } else if (input.equalsIgnoreCase("stand")) {
                stand = true;
                break;
            } else {

            }
        }
        if (!stand) {
            System.out.println("\nYou went bust!");
        }
        newGame.endStep();
        System.out.println("Would you like to play again?");
        String playAgain = scanner.nextLine();
        return playAgain.equalsIgnoreCase("yes");
    }

    public static List<Card> createDeck() {

        List<Card> deck = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(suit, value));
            }
        }

        Collections.shuffle(deck);
        return deck;
    }
}