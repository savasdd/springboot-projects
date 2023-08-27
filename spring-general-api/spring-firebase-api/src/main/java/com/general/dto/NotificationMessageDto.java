package com.general.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationMessageDto {
    private String token;
    private String title;
    private String body;
    private String image;
    private Map<String, String> data;

}
