package com.keli.crawler.core.api.selector.item;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import java.util.ArrayList;
import java.util.List;

public abstract class ItemSelector {

  private Class<?> classType;
  private String tagCssQuery;
  private List<FieldSelector> selectors;

  ItemSelector(Class<?> classType, String tagCssQuery) {
    this.classType = classType;
    this.tagCssQuery = tagCssQuery;
    this.selectors = new ArrayList<>();
  }

  public abstract void addSelector(FieldSelector fieldSelector);

  public Class<?> getClassType() {
    return classType;
  }

  public String getTagCssQuery() {
    return tagCssQuery;
  }

  public List<FieldSelector> getSelectors() {
    return selectors;
  }
}
