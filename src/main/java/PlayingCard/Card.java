package PlayingCard;

public class Card {

    private final CardValue value;
    private final CardSuit suit;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }



    public String getName() {
        return "The " + value + " of " + suit;
    }


    public int getValue() {
        return switch (value) {
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case TEN, JACK, QUEEN, KING, ACE -> 10;
        };
    }
}
