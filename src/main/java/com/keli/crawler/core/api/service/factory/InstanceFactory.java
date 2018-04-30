package com.keli.crawler.core.api.service.factory;

import com.keli.crawler.core.api.service.exception.CannotInstantiateException;

public class InstanceFactory {

  public static <T> T newInstance(Class<T> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new CannotInstantiateException("Cannot instantiate new class", e);
    }
  }
}
