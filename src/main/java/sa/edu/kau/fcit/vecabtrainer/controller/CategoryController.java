package sa.edu.kau.fcit.vecabtrainer.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import sa.edu.kau.fcit.vecabtrainer.config.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.edu.kau.fcit.vecabtrainer.config.Firebase;
import sa.edu.kau.fcit.vecabtrainer.model.Category;

@RestController
public class CategoryController {



    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        Logger.getInstance().info("Request received: GET /categories");
        Firestore db = Firebase.getFirestore();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("categories").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            List<Category> categories = new ArrayList<>();
            for (QueryDocumentSnapshot document : documents) {
                Category category = document.toObject(Category.class);
                if (category != null) {
                    categories.add(category);
                }
            }
            Logger.getInstance().info("Found " + categories.size() + " categories");
            return categories;
        } catch (InterruptedException | ExecutionException e) {
            Logger.getInstance().error("Error fetching categories: " + e.getMessage());
            Thread.currentThread().interrupt();
            return new ArrayList<>();
        }
    }
}
