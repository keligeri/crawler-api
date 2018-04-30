package com.keli.crawler.core.api.service.pagination.strategy;

import com.keli.crawler.core.api.service.pagination.selector.PaginationSelector;

public interface PaginationStrategy {

  String getRootUrl();

  String getSearchResultUrl();

  PaginationSelector getPaginationSelector();
}
