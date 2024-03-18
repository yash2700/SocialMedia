package com.apiwiz.Social.Media.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StandardException extends RuntimeException {
    public StandardException(String message){
        super(message);
    }
}
