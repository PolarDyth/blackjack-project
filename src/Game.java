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

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void printPlayerHand() {
        System.out.print("In your hand you currently have ");
        playerHand.forEach(s -> System.out.print(", " + s.getCardName()));
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public void printDealerHand() {
        System.out.print("The dealers hand is currently");
        dealerHand.forEach(s -> System.out.print(", " + s.getCardName()));
        System.out.println();
    }

    public void playerDraw() {

        playerHand.add(deck.get(0));
        System.out.println("You drew " + deck.get(0).getCardName());
        deck.remove(0);
        printPlayerHand();
    }

    public void dealerDraw() {

        dealerHand.add(deck.get(0));
        deck.remove(0);
    }

    public int calculatePlayer() {
        int total = 0;
        int highAceTotal = 0;

        for (Card value : playerHand) {
            total += value.getValue();
        }
        boolean hasAce = false;
        for (Card card : playerHand) {
            if (card.getValue() == 1) {
                hasAce = true;
                break;
            }
        }


        if (hasAce) {
            highAceTotal = total + 10;
        }
        return hasAce ? (highAceTotal > 21 ? total : highAceTotal) : total;
    }

    private int calculateDealer() {
        int total = 0;
        int highAceTotal = 0;

        boolean hasAce = false;
        for (Card card : dealerHand) {
            if (card.getValue() == 1) {
                hasAce = true;
                break;
            }
        }

        for (Card card : dealerHand) {
            total += card.getValue();
        }

        if (hasAce) {
            highAceTotal = total + 10;
        }

        return hasAce ? (highAceTotal > 21 ? total : highAceTotal) : total;
    }

    public void endStep() {

        for (int i = 0; i < 4; i++) {
            dealerDraw();
        }

        printDealerHand();

        if (calculatePlayer() > 21) {
            System.out.println("You lose!");
        } else if ((calculateDealer() > 21) && (calculatePlayer() < 21)) {
            System.out.println("You win!");
        } else if (calculateDealer() > calculatePlayer()) {
            System.out.println("You lose!");
        } else if (calculatePlayer() == calculateDealer()) {
            System.out.println("It's a tie!");
        } else if (calculatePlayer() > calculateDealer()) {
            System.out.println("You win!");
        }
    }
}
