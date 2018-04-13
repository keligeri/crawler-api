package com.keli.crawler.core.api.service.parser.strategy;

import com.keli.crawler.core.api.selector.Selector;
import com.keli.crawler.core.api.service.pagination.strategy.PaginationStrategy;

public interface ParserStrategy {

  Selector getItemSelector();

  PaginationStrategy getPaginationStrategy();
}
