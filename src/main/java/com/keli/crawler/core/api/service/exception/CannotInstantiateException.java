package com.keli.crawler.core.api.service.exception;

public class CannotInstantiateException extends RuntimeException{

  public CannotInstantiateException(String message, Throwable cause) {
    super(message, cause);
  }
}
