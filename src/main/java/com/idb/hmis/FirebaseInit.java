package com.idb.hmis;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;

public class FirebaseInit {
    public static void main(String[] args) {
        try {
            FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://your-project-id.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase Initialized!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
