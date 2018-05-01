package com.keli.crawler.core.api.validator;

import com.keli.crawler.core.api.exception.InvalidFieldException;

public class FieldValidator {

  public static void validateField(String fieldName) {
    if (fieldName == null || fieldName.length() <= 1) {
      throw new InvalidFieldException("FieldName must be a valid, non empty String!");
    }
  }

  public static void validateClassHasField(Class<?> classType, String fieldName) {
    try {
      classType.getDeclaredField(fieldName);
    } catch (NoSuchFieldException e) {
      throw new InvalidFieldException(
          "Invalid field name, reference class has to be the field!", e);
    }
  }
}
