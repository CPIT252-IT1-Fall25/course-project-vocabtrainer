package sa.edu.kau.fcit.vecabtrainer;

import com.google.cloud.firestore.Firestore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sa.edu.kau.fcit.vecabtrainer.config.FirestoreInit;

@SpringBootApplication
public class VecabtrainerApplication {

	public static void main(String[] args) {
        Firestore db = FirestoreInit.getFirestore();
		SpringApplication.run(VecabtrainerApplication.class, args);
	}

}
