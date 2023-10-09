package com.general.controller;

import com.general.dto.WSMessage;
import com.general.dto.WSResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {

    @MessageMapping("/person")
    @SendTo("/topic/news")
    public WSResponse broadcastNews(WSMessage message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Messages: " + message.getName());

        return new WSResponse(HtmlUtils.htmlEscape(message.getName()));
    }
}
