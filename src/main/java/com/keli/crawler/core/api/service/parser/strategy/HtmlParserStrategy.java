package com.keli.crawler.core.api.service.parser.strategy;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.service.pagination.strategy.PaginationStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HtmlParserStrategy implements ParserStrategy {

  private PaginationStrategy paginationStrategy;
  private FieldSelector itemFieldSelector;

  @Override
  public FieldSelector getItemFieldSelector() {
    return itemFieldSelector;
  }

  @Override
  public PaginationStrategy getPaginationStrategy() {
    return paginationStrategy;
  }

}
