import PlayingCard.Card;
import PlayingCard.CardSuit;
import PlayingCard.CardValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(suit, value));
            }
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card drawCard() {
        Card topCard = deck.get(0);
        deck.remove(0);
        return topCard;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void reset() {
        deck.clear();
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(suit, value));
            }
        }
    }
}
