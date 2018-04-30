package com.keli.crawler.core.api.selector.field;

import lombok.Getter;
import org.jsoup.nodes.Element;

@Getter
public abstract class FieldSelector<T> {

  String fieldName;
  String cssQuery;

  FieldSelector(String fieldName, String cssQuery) {
    this.fieldName = fieldName;
    this.cssQuery = cssQuery;
  }

  public abstract T execute(Element element);
}
