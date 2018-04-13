package com.keli.crawler.core.api.service.parser;

import com.keli.crawler.core.api.service.exception.FailedConnectionException;
import com.keli.crawler.core.api.service.parser.strategy.HtmlParserStrategy;
import com.keli.crawler.core.api.service.parser.strategy.ParserStrategy;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@AllArgsConstructor
public class HtmlParser implements Parser {

  private ParserStrategy parserStrategy;


  @Override
  public void parseItems() {
    HtmlParserStrategy htmlParserStrategy = (HtmlParserStrategy) parserStrategy;

    getItems();

  }

  @Override
  public void saveItems() {

  }

  private void getItems() {
    String rootUrl = parserStrategy.getPaginationStrategy().getSearchResultUrl();
    Document document = getDocument(rootUrl);

    // iterate through the selectors and create a new instance
  }

  private Document getDocument(String rootUrl) {
    try {
      return Jsoup.connect(rootUrl).get();
    } catch (IOException e) {
      throw new FailedConnectionException("Cannot connect to the given url", e);
    }
  }
}
