package com.keli.crawler.core.api.service.validator;

import com.keli.crawler.core.api.service.exception.InvalidSelectorException;

public class QueryValidator {

  public static void validateQuery(String selector) {
    if (selector == null || selector.length() <= 0) {
      throw new InvalidSelectorException("FieldSelector must be a valid, non empty String!");
    }
  }
}
