package com.apiwiz.Social.Media.exceptions;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private String timeStamp;
    private int code;
    private String message;
}
