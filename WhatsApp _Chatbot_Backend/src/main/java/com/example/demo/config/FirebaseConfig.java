package com.example.demo.config;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
           
            InputStream serviceAccount = new ClassPathResource("whatsapp-bot-51ccc-firebase-adminsdk-fbsvc-9a1b184ecd.json").getInputStream();

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("\"https://whatsapp-bot-51ccc.firebaseio.com\"") 
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println(" Firebase Initialized Successfully!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
