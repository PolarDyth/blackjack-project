import PlayingCard.Card;
import PlayingCard.CardSuit;
import PlayingCard.CardValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayingCardUnitTests {

    @Test
    @DisplayName("Check if multiple of the same card is found in deck")
    public void multipleInDeckCheck() {
        var testDeck = Main.createDeck();
        List<String> inDeck = new ArrayList<>();
        for (Card card : testDeck) {
            if (inDeck.contains("" + card.getSuit() + card.getValue())) {
                Assertions.fail("Multiple of the same card found in deck");
            } else {
                inDeck.add("" + card.getSuit() + card.getValue());
            }
        }
    }

    @Test
    @DisplayName("Check all correct cards are in deck")
    public void allCardsInDeck() {
        var testDeck = Main.createDeck();

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                boolean passIteration = false;
                for (int i = 0; i < 52; i++) {
                    Card currentCard = testDeck.get(i);
                    if (("" + currentCard.getValue() + currentCard.getSuit()).equalsIgnoreCase("" + value + suit)) {
                        passIteration = true;
                        break;
                    }
                }

                if (!passIteration) {
                    Assertions.fail("Not all cards are in deck");
                }
            }
        }
    }
}
