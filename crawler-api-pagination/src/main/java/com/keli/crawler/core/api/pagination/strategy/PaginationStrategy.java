package com.keli.crawler.core.api.pagination.strategy;

import com.keli.crawler.core.api.pagination.selector.PaginationSelector;

public interface PaginationStrategy {

  String getRootUrl();

  String getSearchResultUrl();

  PaginationSelector getPaginationSelector();
}
