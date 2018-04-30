package com.keli.crawler.core.api.service.utils;

public class StringUtils {

  public static double getDoubleFromString(String text) {
    if (text == null || text.isEmpty()) {
      return 0.0;
    }

    String digits = "";
    for (Character ch : text.toCharArray()) {
      if (Character.isDigit(ch)) {
        digits += ch;
      }
    }

    return digits.isEmpty() ? 0.0 : Double.valueOf(digits);
  }
}
