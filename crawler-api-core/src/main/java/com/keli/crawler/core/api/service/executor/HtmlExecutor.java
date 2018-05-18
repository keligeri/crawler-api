package com.keli.crawler.core.api.service.executor;

import com.keli.crawler.core.api.service.parser.Parser;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HtmlExecutor<T> implements Executor<T> {

  private Parser<T> selectorParser;

  @Override
  public List<T> parseItems() {
    return selectorParser.executeSelectors();
  }

  @Override
  public void saveItems() {
    // TODO implement different saving strategy (db (mySQL, pSQL), terminal etc.), move it into different module later
  }
}
