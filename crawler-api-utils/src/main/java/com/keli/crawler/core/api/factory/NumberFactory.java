package com.keli.crawler.core.api.factory;

public class NumberFactory {

  public static Long newLong(String text) {
    String digits = "";
    if (isNonEmptyString(text)) {
      digits = getDigits(text);
    }

    return digits.isEmpty() ? 0 : Long.valueOf(digits);
  }

  public static float newFloat(String text) {
    String digits = "";
    if (isNonEmptyString(text)) {
      digits = getDigits(text);
    }

    return digits.isEmpty() ? 0 : Float.valueOf(digits);
  }

  public static double newDouble(String text) {
    String digits = "";
    if (isNonEmptyString(text)) {
      digits = getDigits(text);
    }

    return digits.isEmpty() ? 0.0 : Double.valueOf(digits);
  }

  public static int newInteger(String text) {
    String digits = "";
    if (isNonEmptyString(text)) {
      digits = getDigits(text);
    }

    return digits.isEmpty() ? 0 : Integer.valueOf(digits);
  }

  public static byte newByte(String text) {
    String digits = "";
    if (isNonEmptyString(text)) {
      digits = getDigits(text);
    }

    return digits.isEmpty() ? 0 : Byte.valueOf(digits);
  }

  private static boolean isNonEmptyString(String text) {
    return text != null && !text.isEmpty();
  }

  private static String getDigits(String text) {
    String digits = "";

    for (Character ch : text.toCharArray()) {
      if (Character.isDigit(ch)) {
        digits += ch;
      }
    }

    return digits;
  }
}
