package com.keli.crawler.core.api.service.pagination.strategy;

import com.keli.crawler.core.api.service.pagination.selector.PaginationSelector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HtmlPaginationStrategy implements PaginationStrategy {

  public String rootUrl;
  private String searchResultUrl;
  private PaginationSelector paginationSelector;

  @Override
  public String getRootUrl() {
    return rootUrl;
  }

  @Override
  public String getSearchResultUrl() {
    return searchResultUrl;
  }

  @Override
  public PaginationSelector getPaginationSelector() {
    return paginationSelector;
  }
}
