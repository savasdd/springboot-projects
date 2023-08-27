package com.general.service;

import com.general.dto.NotificationMessageDto;
import com.general.dto.MulticastMessageDto;
import com.google.firebase.messaging.FirebaseMessagingException;

import java.util.List;

public interface FirebaseService {

    String postToCondition(NotificationMessageDto message) throws FirebaseMessagingException;

    String postToTopic(String message, String topic) throws FirebaseMessagingException;


    String postToClient(String message, String registrationToken) throws FirebaseMessagingException;

    List<String> postToClients(MulticastMessageDto message) throws FirebaseMessagingException;

    void createSubscription(String topic, List<String> registrationTokens) throws FirebaseMessagingException;

    void deleteSubscription(String topic, String registrationToken) throws FirebaseMessagingException;

}
