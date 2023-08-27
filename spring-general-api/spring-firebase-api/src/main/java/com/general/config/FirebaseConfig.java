package com.general.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
//@EnableConfigurationProperties(FirebaseProperties.class)
public class FirebaseConfig {

    //private final FirebaseProperties firebaseProperties;

//    public FirebaseConfig(FirebaseProperties firebaseProperties) {
//        this.firebaseProperties = firebaseProperties;
//    }

//    @Bean
//    GoogleCredentials googleCredentials() {
//        try {
//            if (firebaseProperties.getService() != null) {
//                try (InputStream is = firebaseProperties.getService().getInputStream()) {
//                    return GoogleCredentials.fromStream(is);
//                }
//            } else {
//                var google = GoogleCredentials.getApplicationDefault();
//                return google;
//            }
//        } catch (IOException ioe) {
//            throw new RuntimeException(ioe);
//        }
//    }
//
//    @Bean
//    FirebaseApp firebaseApp(GoogleCredentials credentials) {
//        FirebaseOptions options = FirebaseOptions.builder().setCredentials(credentials).build();
//
//        return FirebaseApp.initializeApp(options);
//    }
//
//    @Bean
//    FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
//        return FirebaseMessaging.getInstance(firebaseApp);
//    }

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
        FirebaseOptions options = FirebaseOptions.builder().setCredentials(credentials).build();
        FirebaseApp app = FirebaseApp.initializeApp(options, "my-app");
        return FirebaseMessaging.getInstance(app);
    }

}
