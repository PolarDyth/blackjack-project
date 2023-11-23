import PlayingCard.Card;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Card> deck;
    private List<Card> playerHand;
    private List<Card> dealerHand;

    public Game(List<Card> deck) {
        this.deck = deck;
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }


    private void printPlayerHand() {
        System.out.print("In your hand you currently have");
        playerHand.forEach(s -> System.out.print(", " + s.getName()));
    }


    private void printDealerHand() {
        System.out.print("The dealers hand is currently");
        dealerHand.forEach(s -> System.out.print(", " + s.getName()));
        System.out.println();
    }

    public void playerDraw() {

        playerHand.add(deck.get(0));
        System.out.println("You drew " + deck.get(0).getName());
        deck.remove(0);
        printPlayerHand();
    }

    private void dealerDraw() {

        dealerHand.add(deck.get(0));
        deck.remove(0);
    }

    private int calculateHand(List<Card> hand) {
        int total = 0;
        int highAceTotal = 0;

        for (Card value : hand) {
            total += value.getTrueValue();
        }
        boolean hasAce = false;
        for (Card card : hand) {
            if (card.getTrueValue() == 1) {
                hasAce = true;
                break;
            }
        }


        if (hasAce) {
            highAceTotal = total + 10;
        }
        return hasAce ? (highAceTotal > 21 ? total : highAceTotal) : total;
    }

    public int calculatePlayer() {
        return calculateHand(playerHand);
    }

    private int calculateDealer() {
        return calculateHand(dealerHand);
    }

    public void endStep() {

        for (int i = 0; i < 4; i++) {
            dealerDraw();
        }

        printDealerHand();
        int calcPlayerHand = calculatePlayer();
        int calcDealerHand = calculateDealer();

        if (calcPlayerHand > 21) {
            System.out.println("You lose!");
        } else if ((calcDealerHand > 21) && (calcPlayerHand < 21)) {
            System.out.println("You win!");
        } else if (calcDealerHand > calcPlayerHand) {
            System.out.println("You lose!");
        } else if (calcPlayerHand == calcDealerHand) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("You win!");
        }
    }
}
