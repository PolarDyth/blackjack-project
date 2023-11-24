import PlayingCard.CardSuit;
import PlayingCard.CardValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DeckUnitTests {

    @Test
    @DisplayName("Check deck creates a deck that has 52 unique cards")
    public void CheckDeckCreatesUniqueCards() {
        Deck testDeck = new Deck();

        int counter = 0;
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                var expectedName = "The " + value.name() + " of " + suit.name();
                Assertions.assertEquals(expectedName, testDeck.getDeck().get(counter).getName());

                counter++;
            }
        }
    }

    @Test
    @DisplayName("Check drawCard() removes first card from the list and returns the top card removed")
    public void checkDrawCard() {
        Deck testDeck = new Deck();
        var topDeck = testDeck.getDeck().get(0);
        var removedCard = testDeck.drawCard();

        Assertions.assertEquals(51, testDeck.getDeck().size());
        Assertions.assertEquals(topDeck, removedCard);
    }

    @Test
    @DisplayName("Check that shuffle() shuffles the deck")
    public void checkShuffle() {
        Deck testDeck = new Deck();
        var originalDeck = new ArrayList<>(testDeck.getDeck());

        testDeck.shuffle();

        Assertions.assertNotEquals(originalDeck, testDeck.getDeck());
    }

    @Test
    @DisplayName("Check that reset() resets the deck to how it would be when you create an instance of deck")
    public void checkReset() {
        Deck testDeck = new Deck();
        var originalDeck = new ArrayList<>(testDeck.getDeck());

        testDeck.getDeck().clear();
        testDeck.reset();

        for (int i = 0; i < 52; i++) {
            Assertions.assertEquals(originalDeck.get(i).getName(), testDeck.getDeck().get(i).getName());
        }
    }
}