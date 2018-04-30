package com.keli.crawler.core.api.selector.field;

import com.keli.crawler.core.api.service.validator.FieldValidator;
import com.keli.crawler.core.api.service.validator.QueryValidator;

public class TagFieldSelector extends FieldSelector {

  @Override
  public void addQuery(String fieldName, String cssQuery) {
    FieldValidator.validateField(fieldName);
    QueryValidator.validateQuery(cssQuery);

    queries.put(fieldName, cssQuery);
  }
}
