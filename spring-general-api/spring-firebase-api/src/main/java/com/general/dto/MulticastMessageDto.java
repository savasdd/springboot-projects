package com.general.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MulticastMessageDto {
    private String data;
    private List<String> registrationTokens;
}
