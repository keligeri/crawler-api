package com.keli.crawler.core.api.service.parser;

import com.keli.crawler.core.api.service.parserexecutor.Parser;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HtmlExecutor<T> implements Executor<T> {

  private Parser<T> selectorParser;

  @Override
  public List<T> parseItems() {
    return selectorParser.executeSelector();
  }

  @Override
  public void saveItems() {
    // TODO implement different saving strategy (db (mySQL, pSQL), terminal etc.), move it into different module later
  }
}
