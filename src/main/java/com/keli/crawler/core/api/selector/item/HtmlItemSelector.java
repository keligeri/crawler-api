package com.keli.crawler.core.api.selector.item;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.service.validator.QueryValidator;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class HtmlItemSelector implements ItemSelector {

  private Class<?> classType;
  private String tagCssQuery;
  private List<FieldSelector> selectors;

  public HtmlItemSelector(Class<?> classType, String tagCssQuery) {
    this.classType = classType;
    this.tagCssQuery = tagCssQuery;
    this.selectors = new ArrayList<>();
  }

  public void addSelector(FieldSelector fieldSelector) {
    QueryValidator.validateQuery(fieldSelector.getCssQuery());
    selectors.add(fieldSelector);
  }
}
