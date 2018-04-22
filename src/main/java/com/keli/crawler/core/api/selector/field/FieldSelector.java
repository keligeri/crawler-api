package com.keli.crawler.core.api.selector.field;

import java.util.Map;

public interface FieldSelector {

  void addQuery(String fieldName, String selector);

  Map<String, String> getQueries();
}
