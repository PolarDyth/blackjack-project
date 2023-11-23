import PlayingCard.Card;
import PlayingCard.CardSuit;
import PlayingCard.CardValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayingCardUnitTests {

    @Test
    @DisplayName("Card will return the correct name when constructed and getName is called")
    public void CorrectNameReturnedWhenConstructed() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                var card = new Card(suit, value);
                var expectedName = "The " + value.name() + " of " + suit.name();

                Assertions.assertEquals(expectedName, card.getName());
            }
        }
    }
}