package com.keli.crawler.core.api.service.parser.strategy;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.pagination.strategy.PaginationStrategy;

public interface ParserStrategy {

  FieldSelector getItemFieldSelector();

  PaginationStrategy getPaginationStrategy();
}
