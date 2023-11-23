//import PlayingCard.Card;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UnitTests {
//
//    @Test
//    @DisplayName("Check if 52 cards are in deck")
//    public void deckNumCheck() {
//        var deck= Main.createDeck();
//        Assertions.assertEquals(52, deck.size());
//    }
//
//    @Test
//    @DisplayName("Check if right number of suits in deck")
//    public void deckSuitCheck() {
//        var deck = Main.createDeck();
//        int diamonds = 0;
//        int hearts = 0;
//        int spades = 0;
//        int clubs = 0;
//
//        for(PlayingCard.Card card : deck) {
//            switch (card.getSuit()) {
//                case 0 -> diamonds += 1;
//                case 1 -> hearts += 1;
//                case 2 -> spades += 1;
//                case 3 -> clubs += 1;
//                default -> Assertions.fail("Suit not in range added");
//            }
//        }
//
//        int finalDiamonds = diamonds;
//        int finalHearts = hearts;
//        int finalSpades = spades;
//        int finalClubs = clubs;
//        Assertions.assertAll(
//                () -> Assertions.assertEquals(13, finalDiamonds),
//                () -> Assertions.assertEquals(13, finalHearts),
//                () -> Assertions.assertEquals(13, finalSpades),
//                () -> Assertions.assertEquals(13, finalClubs)
//        );
//    }
//
//    @Test
//    @DisplayName("Player handsize")
//    public void playerHandsize() {
//        Game testGame = new Game(Main.createDeck());
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
//            for (int i = 0; i < 54; i++) {
//                testGame.playerDraw();
//            }
//        });
//    }
//
//    @Test
//    @DisplayName("Check getSuitName in cards class")
//    public void checkSuitName() {
//        List<Card> testDeck = new ArrayList<>();
//        testDeck.add(new Card(0, 5));
//        testDeck.add(new Card(1, 5));
//        testDeck.add(new Card(2, 5));
//        testDeck.add(new Card(3, 5));
//        testDeck.add(new Card(4, 5));
//        testDeck.add(new Card(-1, 5));
//
//        Assertions.assertEquals(Suit.Diamonds, testDeck.get(0).getSuitName());
//        Assertions.assertEquals(Suit.Hearts, testDeck.get(1).getSuitName());
//        Assertions.assertEquals(Suit.Spades, testDeck.get(2).getSuitName());
//        Assertions.assertEquals(Suit.Clubs, testDeck.get(3).getSuitName());
//        Assertions.assertEquals(Suit.Error, testDeck.get(4).getSuitName());
//        Assertions.assertEquals(Suit.Error, testDeck.get(5).getSuitName());
//    }
//}
