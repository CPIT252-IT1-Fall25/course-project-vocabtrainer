package sa.edu.kau.fcit.vecabtrainer.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Firebase {

    private static boolean isInitialized = false;

    private Firebase() {
    }

    public static synchronized void init() {
        if (isInitialized) {
            return;
        }

        // Check if Default app exists in FirebaseApp list safely
        boolean hasDefaultApp = false;
        List<FirebaseApp> apps = FirebaseApp.getApps();
        for (FirebaseApp app : apps) {
            if (FirebaseApp.DEFAULT_APP_NAME.equals(app.getName())) {
                hasDefaultApp = true;
                break;
            }
        }

        if (hasDefaultApp) {
            isInitialized = true;
            System.out.println("FirebaseApp already initialized.");
            return;
        }

        try {
            InputStream serviceAccount = Firebase.class.getResourceAsStream("/firebase-adminsdk-secrets.json");

            if (serviceAccount == null) {
                throw new IOException("Firebase service account file not found in classpath: /firebase-adminsdk-secrets.json");
            }

            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();

            FirebaseApp.initializeApp(options);
            isInitialized = true;
            System.out.println("Firebase is ready.");

        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize Firebase: " + e.getMessage(), e);
        }
    }

    public static Firestore getFirestore() {
        init();
        return FirestoreClient.getFirestore();
    }

    public static FirebaseAuth getFirebaseAuth() {
        init();
        return FirebaseAuth.getInstance();
    }
}
