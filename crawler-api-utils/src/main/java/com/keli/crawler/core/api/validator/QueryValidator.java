package com.keli.crawler.core.api.validator;

import com.keli.crawler.core.api.exception.InvalidSelectorException;

public class QueryValidator {

  public static void validateQuery(String selector) {
    if (selector == null || selector.length() <= 0) {
      throw new InvalidSelectorException("FieldSelector must be a valid, non empty String!");
    }
  }
}
