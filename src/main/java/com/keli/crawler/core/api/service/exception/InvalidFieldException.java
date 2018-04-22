package com.keli.crawler.core.api.service.exception;

public class InvalidFieldException extends RuntimeException {

  public InvalidFieldException(String message) {
    super(message);
  }

  public InvalidFieldException(String message, Throwable cause) {
    super(message, cause);
  }
}
