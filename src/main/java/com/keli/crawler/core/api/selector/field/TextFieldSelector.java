package com.keli.crawler.core.api.selector.field;

import com.keli.crawler.core.api.service.validator.QueryValidator;
import java.util.HashMap;
import java.util.Map;

public class TextFieldSelector implements FieldSelector {

  private final QueryValidator queryValidator = new QueryValidator();

  private Map<String, String> queries = new HashMap<>();

  @Override
  public void addQuery(String fieldName, String cssQueries) {
    queryValidator.validateSelector(fieldName, cssQueries);

    queries.put(fieldName, cssQueries);
  }

  @Override
  public Map<String, String> getQueries() {
    return queries;
  }
}
