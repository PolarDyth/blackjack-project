public class Card {

    private final int suit;
    private final int value;
    private final int trueValue;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        if (value > 10) {
            trueValue = 10;
        } else {
            trueValue = value;
        }
    }

    private int getSuit() {
        return suit;
    }

    public int getValue() {
        return trueValue;
    }

    public String getCardName() {

        String cardName;
        switch (suit) {
            case 0 -> cardName = "Diamonds";
            case 1 -> cardName = "Hearts";
            case 2 -> cardName = "Spades";
            case 3 -> cardName = "Clubs";
            default -> cardName = "Error value is " + suit;
        }

        if (value < 11 && value > 1) {
            cardName = ("The " + value + " of " + cardName);
        } else {
            switch (value) {
                case 1 -> cardName = ("The Ace of " + cardName);
                case 11 -> cardName = ("The Jack of " + cardName);
                case 12 -> cardName = ("The Queen of " + cardName);
                case 13 -> cardName = ("The King of " + cardName);
                default -> cardName = "Error value is " + suit;
            }
        }

        return cardName;
    }
}
