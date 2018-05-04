package com.keli.crawler.core.api.selector.field;

import lombok.Getter;

@Getter
public abstract class FieldSelector {

  String fieldName;
  String cssQuery;

  FieldSelector(String fieldName, String cssQuery) {
    this.fieldName = fieldName;
    this.cssQuery = cssQuery;
  }
}
