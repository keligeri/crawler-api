package com.keli.crawler.core.api.service.parser;

import com.keli.crawler.core.api.service.parser.parserstrategy.HtmlParserStrategy;
import com.keli.crawler.core.api.service.parser.parserstrategy.ParserStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HtmlParser implements Parser {

  private ParserStrategy parserStrategy;

  @Override
  public void parseItems() {
    HtmlParserStrategy htmlParserStrategy = (HtmlParserStrategy) parserStrategy;

     htmlParserStrategy.getSelector();
  }

  @Override
  public void saveItems() {

  }
}
