package com.keli.crawler.core.api.selector.item;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.validator.QueryValidator;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class HtmlItemSelector extends ItemSelector {

  public HtmlItemSelector(Class<?> classType, String tagCssQuery) {
    super(classType, tagCssQuery);
  }

  @Override
  public void addSelector(FieldSelector fieldSelector) {
    QueryValidator.validateQuery(fieldSelector.getCssQuery());
    getSelectors().add(fieldSelector);
  }
}
