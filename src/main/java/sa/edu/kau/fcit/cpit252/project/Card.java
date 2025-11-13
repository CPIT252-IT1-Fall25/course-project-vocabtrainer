package sa.edu.kau.fcit.cpit252.project;

public class Card {

    private final Word word;

    public Card(Word word) {
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    public void showFront() {
        System.out.println("Word: " + word.getText());
    }

    public void showBack() {
        System.out.println("Meaning: " + word.getMeaning());
        if (!word.getExampleSentence().isEmpty()) {
            System.out.println("Example: " + word.getExampleSentence());
        }
    }
}
