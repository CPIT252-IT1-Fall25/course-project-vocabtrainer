package sa.edu.kau.fcit.cpit252.project;

public class App {
    public static void main(String[] args) {

        Word word = new Word.Builder("abandon", "to leave something behind")
                .partOfSpeech("verb")
                .exampleSentence("He decided to abandon the old project.")
                .difficultyLevel(3)
                .addSynonym("leave")
                .addSynonym("desert")
                .build();

        Card card = new Card(word);

        card.showFront();
        card.showBack();
    }
}
