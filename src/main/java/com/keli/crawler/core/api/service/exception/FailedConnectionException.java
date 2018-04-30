package com.keli.crawler.core.api.service.exception;

public class FailedConnectionException extends RuntimeException {

  public FailedConnectionException(String message, Throwable cause) {
    super(message, cause);
  }
}
