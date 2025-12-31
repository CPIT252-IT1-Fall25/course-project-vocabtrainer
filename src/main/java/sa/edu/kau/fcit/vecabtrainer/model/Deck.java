package sa.edu.kau.fcit.vecabtrainer.model;

public class Deck {
    private String deckId;
    private String name;
    private String description;
    private String category;

    private Deck() {
        // No init code needed, builder handles the initialization
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String deckId;
        private String name;
        private String description;
        private String category;

        public Builder deckId(String deckId) {
            this.deckId = deckId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Deck build() {
            Deck deck = new Deck();
            deck.setDeckId(deckId);
            deck.setName(name);
            deck.setDescription(description);
            deck.setCategory(category);
            return deck;
        }
    }
}
