package com.example.gamedemo.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends RuntimeException {

  @Builder
  public NotFoundException(String message) {
    super(message);
  }
}
