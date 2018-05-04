package com.keli.crawler.core.api.selector.item;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import java.util.ArrayList;
import java.util.List;

public abstract class ItemSelector<T> {

  private Class<T> classType;
  private String cssQuery;
  private List<FieldSelector> selectors;

  ItemSelector(Class<T> classType, String tagCssQuery) {
    this.classType = classType;
    this.cssQuery = tagCssQuery;
    this.selectors = new ArrayList<>();
  }

  public abstract void addSelector(FieldSelector fieldSelector);

  public Class<T> getClassType() {
    return classType;
  }

  public String getCssQuery() {
    return cssQuery;
  }

  public List<FieldSelector> getSelectors() {
    return selectors;
  }
}
