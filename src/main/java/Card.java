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


    public int getValue() {
        return trueValue;
    }

    public int getSuit() {
        return suit;
    }

    public Suit getSuitName() {

        Suit suitName;
        switch (suit) {
            case 0 -> suitName = Suit.Diamonds;
            case 1 -> suitName = Suit.Hearts;
            case 2 -> suitName = Suit.Spades;
            case 3 -> suitName = Suit.Clubs;
            default -> suitName = Suit.Error;
        }

        return suitName;
    }

    public String getName() {

        String cardName = String.valueOf(getSuitName());

        if (value < 11 && value > 1) {
            cardName = ("The " + value + " of " + cardName);
        } else {
            switch (value) {
                case 1 -> cardName = ("The Ace of " + cardName);
                case 11 -> cardName = ("The Jack of " + cardName);
                case 12 -> cardName = ("The Queen of " + cardName);
                case 13 -> cardName = ("The King of " + cardName);
                default -> cardName = "Error value is " + value;
            }
        }

        return cardName;
    }
}
