package com.general.controller;

import com.general.dto.NotificationMessageDto;
import com.general.dto.MulticastMessageDto;
import com.general.service.FirebaseService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FirebaseController {
    private final FirebaseService service;

    public FirebaseController(FirebaseService service) {
        this.service = service;
    }

    @PostMapping("/firebases")
    public ResponseEntity<String> postToCondition(@RequestBody NotificationMessageDto message) throws FirebaseMessagingException {
        return ResponseEntity.ok(service.postToCondition(message));
    }

    @PostMapping("/firebases/topics/{topic}")
    public ResponseEntity<String> postToTopic(@RequestBody String message, @PathVariable("topic") String topic) throws FirebaseMessagingException {
        return ResponseEntity.ok(service.postToTopic(message, topic));
    }

    @PostMapping("/firebases/clients/{token}")
    public ResponseEntity<String> postToClient(@RequestBody String message, @PathVariable("token") String token) throws FirebaseMessagingException {
        return ResponseEntity.ok(service.postToClient(message, token));
    }

    @PostMapping("/firebases/clients")
    public ResponseEntity<List<String>> postToClients(@RequestBody MulticastMessageDto message) throws FirebaseMessagingException {
        return ResponseEntity.ok(service.postToClients(message));
    }

    @PostMapping("/firebases/subscriptions/{topic}")
    public ResponseEntity<Void> createSubscription(@PathVariable("topic") String topic, @RequestBody List<String> tokens) throws FirebaseMessagingException {
        service.createSubscription(topic, tokens);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/firebases/subscriptions/{topic}/{registrationToken}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable String topic, @PathVariable String token) throws FirebaseMessagingException {
        service.deleteSubscription(topic, token);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
