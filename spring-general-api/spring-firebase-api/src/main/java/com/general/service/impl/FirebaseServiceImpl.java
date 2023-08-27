package com.general.service.impl;

import com.general.dto.MulticastMessageDto;
import com.general.dto.NotificationMessageDto;
import com.general.service.FirebaseService;
import com.google.firebase.messaging.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FirebaseServiceImpl implements FirebaseService {

    private final FirebaseMessaging fcm;

    public FirebaseServiceImpl(FirebaseMessaging fcm) {
        this.fcm = fcm;
    }

    @Override
    public String postToCondition(NotificationMessageDto dto) throws FirebaseMessagingException {
        Notification notification = Notification.builder().setTitle(dto.getTitle()).setBody(dto.getBody()).setImage(dto.getImage()).build();
        Message message = Message.builder().setToken(dto.getToken()).setNotification(notification).putAllData(dto.getData()).build();

        fcm.send(message);
        return "Success Sending";
    }

    @Override
    public String postToTopic(String message, String topic) throws FirebaseMessagingException {
        Message msg = Message.builder().setTopic(topic).putData("body", message).build();
        String id = fcm.send(msg);

        log.info("send notification: {}", topic);
        return id;
    }


    @Override
    public String postToClient(String message, String registrationToken) throws FirebaseMessagingException {
        Message msg = Message.builder().setToken(registrationToken).putData("body", message).build();

        String id = fcm.send(msg);
        return id;
    }

    @Override
    public List<String> postToClients(MulticastMessageDto message) throws FirebaseMessagingException {
        MulticastMessage msg = MulticastMessage.builder().addAllTokens(message.getRegistrationTokens()).putData("body", message.getData()).build();
        BatchResponse response = fcm.sendMulticast(msg);

        List<String> ids = response.getResponses().stream().map(r -> r.getMessageId()).collect(Collectors.toList());
        return ids;
    }

    @Override
    public void createSubscription(String topic, List<String> registrationTokens) throws FirebaseMessagingException {
        fcm.subscribeToTopic(registrationTokens, topic);
    }

    @Override
    public void deleteSubscription(String topic, String registrationToken) throws FirebaseMessagingException {
        fcm.subscribeToTopic(Arrays.asList(registrationToken), topic);
    }
}
