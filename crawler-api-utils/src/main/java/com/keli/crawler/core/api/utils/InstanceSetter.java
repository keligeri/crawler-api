package com.keli.crawler.core.api.utils;

import com.keli.crawler.core.api.exception.CannotInstantiateException;
import com.keli.crawler.core.api.factory.NumberFactory;
import java.lang.reflect.Field;

public class InstanceSetter {

  public static <T> void setField(T object, String fieldName, String fieldValue) {
    try {
      Field field = object.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);

      setFieldValue(object, field, fieldValue);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
      throw new CannotInstantiateException("Cannot instantiate object properly!", e);
    }
  }

  private static <T> void setFieldValue(
      T object, Field field, String fieldValue) throws IllegalAccessException {

    Class<?> refType = field.getType();

    if (field.getType().isAssignableFrom(String.class)) {
      field.set(object, fieldValue);
    } else if (refType == Double.TYPE || refType.isAssignableFrom(Double.class)) {
      field.set(object, NumberFactory.newDouble(fieldValue));
    } else if (refType == Integer.TYPE || refType.isAssignableFrom(Integer.class)) {
      field.set(object, NumberFactory.newInteger(fieldValue));
    } else if (refType == Float.TYPE || refType.isAssignableFrom(Float.class)) {
      field.set(object, NumberFactory.newFloat(fieldValue));
    } else if (refType == Long.TYPE || refType.isAssignableFrom(Long.class)) {
      field.set(object, NumberFactory.newLong(fieldValue));
    } else if (refType == Byte.TYPE || refType.isAssignableFrom(Byte.class)) {
      field.set(object, NumberFactory.newByte(fieldValue));
    } else {
      throw new IllegalArgumentException("Not supported reference type!");
    }
  }
}
