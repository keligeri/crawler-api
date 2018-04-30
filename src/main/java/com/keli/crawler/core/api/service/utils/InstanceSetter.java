package com.keli.crawler.core.api.service.utils;

import java.lang.reflect.Field;

public class InstanceSetter {

  public static <V> void setField(V object, String fieldName, Object fieldValue) {
    try {
      Field field = object.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      field.set(object, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
