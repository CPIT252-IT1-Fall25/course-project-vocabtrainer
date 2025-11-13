package sa.edu.kau.fcit.cpit252.project;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private final String text;
    private final String meaning;
    private final String partOfSpeech;
    private final String exampleSentence;
    private final int difficultyLevel;
    private final List<String> synonyms;

    private Word(Builder builder) {
        this.text = builder.text;
        this.meaning = builder.meaning;
        this.partOfSpeech = builder.partOfSpeech;
        this.exampleSentence = builder.exampleSentence;
        this.difficultyLevel = builder.difficultyLevel;
        this.synonyms = builder.synonyms;
    }

    public String getText() {
        return text;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public List<String> getSynonyms() {
        return new ArrayList<>(synonyms);
    }

    @Override
    public String toString() {
        return text + " - " + meaning;
    }

    public static class Builder {

        private final String text;
        private final String meaning;

        private String partOfSpeech = "";
        private String exampleSentence = "";
        private int difficultyLevel = 1;
        private List<String> synonyms = new ArrayList<>();

        public Builder(String text, String meaning) {
            this.text = text;
            this.meaning = meaning;
        }

        public Builder partOfSpeech(String partOfSpeech) {
            this.partOfSpeech = partOfSpeech;
            return this;
        }

        public Builder exampleSentence(String exampleSentence) {
            this.exampleSentence = exampleSentence;
            return this;
        }

        public Builder difficultyLevel(int difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
            return this;
        }

        public Builder addSynonym(String synonym) {
            this.synonyms.add(synonym);
            return this;
        }

        public Word build() {
            return new Word(this);
        }
    }
}
