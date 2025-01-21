package jp.ac.uryukyu.ie.e245701;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class DeckTest {
    @Test
    void testCreateDeck() {
        Deck deck = new Deck();
        List<Card> deckTest = deck.getDeck();
        assertEquals(52, deckTest.size()); // 52枚あるか確認
    }
}