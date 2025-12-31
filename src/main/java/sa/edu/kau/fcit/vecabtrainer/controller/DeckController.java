package sa.edu.kau.fcit.vecabtrainer.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import sa.edu.kau.fcit.vecabtrainer.config.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sa.edu.kau.fcit.vecabtrainer.config.Firebase;
import sa.edu.kau.fcit.vecabtrainer.model.Deck;

@RestController
public class DeckController {




    @GetMapping("/decks/{category}")
    public List<Deck> getDeckByCategory(@PathVariable String category) {
        Logger.getInstance().info("Request received: GET /decks/" + category);
        Firestore db = Firebase.getFirestore();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("decks").whereEqualTo("category", category).get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            List<Deck> decks = new ArrayList<>();
            for (DocumentSnapshot document : documents) {

                Deck deck = Deck.builder()
                        .deckId(document.getString("deckId"))
                        .name(document.getString("name"))
                        .description(document.getString("description"))
                        .category(document.getString("category"))
                        .build();
                        
                decks.add(deck);
            }
            Logger.getInstance().info("Found " + decks.size() + " decks for category: " + category);
            return decks;
        } catch (InterruptedException | ExecutionException e) {
            Logger.getInstance().error("Error fetching decks for category: " + category + " Error: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
