package sa.edu.kau.fcit.vecabtrainer.config;

import com.google.cloud.firestore.Firestore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirebaseTest {

    @Test
    public void testFirebaseInitialization() {
        // This triggers the static block initialization
        Firestore db = Firebase.getFirestore();
        assertNotNull(db, "Firestore instance should not be null");
    }
}
