package sa.edu.kau.fcit.cpit252.vocabtrainer;

import com.google.cloud.firestore.Firestore;
import sa.edu.kau.fcit.cpit252.vocabtrainer.database.FirestoreInit;

public class App {
    public static void main(String[] args) {
        Firestore db = FirestoreInit.getFirestore();
    }
}
