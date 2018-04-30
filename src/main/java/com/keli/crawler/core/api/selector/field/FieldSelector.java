package com.keli.crawler.core.api.selector.field;

import com.keli.crawler.core.api.service.exception.InvalidFieldException;
import java.util.HashMap;
import java.util.Map;

public abstract class FieldSelector {

  Map<String, String> queries = new HashMap<>();

  public abstract void addQuery(String fieldName, String cssQuery);

  public String getQuery(String fieldName) {
    // separate it to a validator class?
    if (fieldName == null) {
      throw new InvalidFieldException("Invalid fieldName, field cannot be null!");
    } else if (queries.size() <= 0) {
      throw new IllegalStateException("Queries size is 0!");
    }

    return queries.get(fieldName);
  }

  public Map<String, String> getQueries() {
    return  queries;
  }
}
