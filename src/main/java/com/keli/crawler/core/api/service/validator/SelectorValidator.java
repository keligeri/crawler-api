package com.keli.crawler.core.api.service.validator;

import com.keli.crawler.core.api.service.exception.IllegalSelectorException;

public class SelectorValidator {

  public void validateSelector(String fieldName, String selector) {
    if (fieldName == null || fieldName.length() <= 1) {
      throw new IllegalSelectorException("FieldName must be a valid, non empty String!");
    }

    if (selector == null || selector.length() <= 3) {
      throw new IllegalSelectorException("Selector must be a valid, non empty String!");
    }
  }
}
