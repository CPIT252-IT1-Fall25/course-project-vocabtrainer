package sa.edu.kau.fcit.vecabtrainer.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RestController;
import sa.edu.kau.fcit.vecabtrainer.config.FirestoreInit;
import sa.edu.kau.fcit.vecabtrainer.model.Deck;

@RestController
public class DeckController {

    @GetMapping("/decks/{category}")
    public List<Deck> getDeckByCategory(@PathVariable String category) {
        Firestore db = FirestoreInit.getFirestore();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("decks").whereEqualTo("category", category).get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            List<Deck> decks = new ArrayList<>();
            for (DocumentSnapshot document : documents) {
                decks.add(document.toObject(Deck.class));
            }
            return decks;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
