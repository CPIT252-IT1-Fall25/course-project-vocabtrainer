package sa.edu.kau.fcit.cpit252.vocabtrainer.database;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreInit {

    private final String secretsPath ="src/main/resources/firebase-adminsdk-secrets.json";
    private static Firestore firestoreInstance;

    private FirestoreInit() {
        try {
            GoogleCredentials credentials =
                    GoogleCredentials.fromStream(new FileInputStream(secretsPath));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();

            FirebaseApp.initializeApp(options);
            firestoreInstance = FirestoreClient.getFirestore();
            System.out.println("Firebase is ready.");

        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize Firestore", e);
        }
    }

    public static Firestore getFirestore() {
        if (firestoreInstance == null) {
            new FirestoreInit();
        }
        return firestoreInstance;
    }
}
