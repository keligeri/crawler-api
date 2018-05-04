package com.keli.crawler.core.api.selector.item;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.validator.QueryValidator;

public class HtmlItemSelector<T> extends ItemSelector<T> {

  public HtmlItemSelector(Class<T> classType, String cssQuery) {
    super(classType, cssQuery);
  }

  @Override
  public void addSelector(FieldSelector fieldSelector) {
    QueryValidator.validateQuery(fieldSelector.getCssQuery());
    getSelectors().add(fieldSelector);
  }
}
