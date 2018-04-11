package com.keli.crawler.core.api.service.parser.parserstrategy;

import com.keli.crawler.core.api.service.selector.Selector;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HtmlParserStrategy implements ParserStrategy {

  private Selector selector;

  @Override
  public Selector getSelector() {
    return selector;
  }
}
