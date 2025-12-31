package sa.edu.kau.fcit.vecabtrainer.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testBuilder() {
        Deck deck = Deck.builder()
                .deckId("test-id")
                .name("Math")
                .description("Math Deck")
                .category("Education")
                .build();

        assertEquals("test-id", deck.getDeckId());
        assertEquals("Math", deck.getName());
        assertEquals("Math Deck", deck.getDescription());
        assertEquals("Education", deck.getCategory());
    }
}
