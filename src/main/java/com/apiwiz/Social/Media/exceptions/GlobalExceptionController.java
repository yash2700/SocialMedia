package com.apiwiz.Social.Media.exceptions;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

  @ExceptionHandler(StandardException.class)
  public ResponseEntity<ErrorMessage> handleExceptions(StandardException e) {
    ErrorMessage errorMessage =
        ErrorMessage.builder()
            .message(e.getMessage())
            .timeStamp(LocalDateTime.now().toString())
            .code(HttpStatus.BAD_REQUEST.value())
            .build();

    logger.error("Error occurred {}", e.getLocalizedMessage());
    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
  }
}
