package com.keli.crawler.core.api.selector;

import java.util.Map;

public interface Selector {

  void addSelector(String fieldName, String selector);

  Map<String, String> getSelectors();

  Class<?> getClassType();
}
