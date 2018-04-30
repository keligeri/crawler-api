package com.keli.crawler.core.api.service.parser;

import com.keli.crawler.core.api.example.domain.House;
import com.keli.crawler.core.api.selector.item.HtmlItemSelector;
import com.keli.crawler.core.api.service.exception.FailedConnectionException;
import com.keli.crawler.core.api.service.executor.ParserExecutor;
import com.keli.crawler.core.api.service.pagination.strategy.HtmlPaginationStrategy;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@AllArgsConstructor
public class HtmlParser implements Parser {

  private HtmlPaginationStrategy paginationStrategy;
  private HtmlItemSelector itemSelector;

  @Override
  public List<House> parseItems() {
    Document document = getDocument();

    ParserExecutor parserExecutor = new ParserExecutor(document, itemSelector);
    List<House> houses = parserExecutor.executeSelector();

    return houses;
  }

  @Override
  public void saveItems() {
    // TODO different saving strategy (db (mySQL, pSQL), terminal etc.)
  }

  private Document getDocument() {
    String rootUrl = paginationStrategy.getSearchResultUrl();
    try {
      return Jsoup.connect(rootUrl).get();
    } catch (IOException e) {
      throw new FailedConnectionException("Cannot connect to the given url", e);
    }
  }
}
