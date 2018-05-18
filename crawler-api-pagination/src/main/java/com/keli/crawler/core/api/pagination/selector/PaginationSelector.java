package com.keli.crawler.core.api.pagination.selector;

import lombok.Getter;

@Getter
public class PaginationSelector {

  private String paginationTagSelector;
  private String attributeName;

  public PaginationSelector(String paginationTagSelector) {
    this.paginationTagSelector = paginationTagSelector;
  }

  public PaginationSelector(String paginationTagSelector, String attributeName) {
    this(paginationTagSelector);
    this.attributeName = attributeName;
  }
}
