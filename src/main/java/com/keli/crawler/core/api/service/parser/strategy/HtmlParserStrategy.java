package com.keli.crawler.core.api.service.parser.strategy;

import com.keli.crawler.core.api.selector.Selector;
import com.keli.crawler.core.api.service.pagination.strategy.PaginationStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HtmlParserStrategy implements ParserStrategy {

  private PaginationStrategy paginationStrategy;
  private Selector itemSelector;

  @Override
  public Selector getItemSelector() {
    return itemSelector;
  }

  @Override
  public PaginationStrategy getPaginationStrategy() {
    return paginationStrategy;
  }

}
