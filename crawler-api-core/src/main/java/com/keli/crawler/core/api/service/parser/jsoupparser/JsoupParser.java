package com.keli.crawler.core.api.service.parser.jsoupparser;

import static java.util.stream.Collectors.toList;

import com.keli.crawler.core.api.pagination.strategy.PaginationStrategy;
import com.keli.crawler.core.api.selector.item.ItemSelector;
import com.keli.crawler.core.api.service.exception.FailedConnectionException;
import com.keli.crawler.core.api.service.parser.Parser;
import com.keli.crawler.core.api.service.parser.jsoupparser.utils.ObjectFactory;
import com.keli.crawler.core.api.service.parser.jsoupparser.utils.PaginationUtil;
import com.keli.crawler.core.api.validator.FieldValidator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupParser<T> implements Parser<T> {

  private PaginationStrategy paginationStrategy;
  private ItemSelector<T> itemSelector;
  private List<T> result;

  public JsoupParser(ItemSelector<T> itemSelector) {
    this.result = new ArrayList<>();
    this.itemSelector = itemSelector;
  }

  public JsoupParser(PaginationStrategy paginationStrategy, ItemSelector<T> itemSelector) {
    this(itemSelector);
    this.paginationStrategy = paginationStrategy;
  }

  public List<T> executeSelectors() {
    validate();

    String nextUrl = paginationStrategy.getSearchResultUrl();
    while (!isEqualWithRootUrl(nextUrl)) {   // TODO: find another solution
      Document currentDocument = getDocument(nextUrl);
      Elements items = getElements(currentDocument);

      List<T> currentResult = getResult(items);
      result.addAll(currentResult);

      nextUrl = PaginationUtil.getNextPageUrl(currentDocument, paginationStrategy);
    }

    return result;
  }

  private void validate() {
    Class<T> referenceType = itemSelector.getClassType();
    itemSelector.getSelectors()
        .forEach(s -> FieldValidator.validateClassHasField(referenceType, s.getFieldName()));
  }

  private boolean isEqualWithRootUrl(String nextUrl) {
    return nextUrl.equals(paginationStrategy.getRootUrl());
  }

  private Document getDocument(String rootUrl) {
    try {
      return Jsoup.connect(rootUrl).get();
    } catch (IOException e) {
      throw new FailedConnectionException("Cannot connect to the given url", e);
    }
  }

  private Elements getElements(Document document) {
    return document.select(itemSelector.getCssQuery());
  }

  private List<T> getResult(Elements elements) {
    return elements.stream()
        .map(e -> ObjectFactory.newObject(e, itemSelector))
        .collect(toList());
  }
}
