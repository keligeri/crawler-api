package com.keli.crawler.core.api.service.parserexecutor;

import com.keli.crawler.core.api.factory.InstanceFactory;
import com.keli.crawler.core.api.pagination.selector.PaginationSelector;
import com.keli.crawler.core.api.pagination.strategy.PaginationStrategy;
import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.selector.item.ItemSelector;
import com.keli.crawler.core.api.service.exception.FailedConnectionException;
import com.keli.crawler.core.api.utils.InstanceSetter;
import com.keli.crawler.core.api.validator.FieldValidator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParserExecutor<T> implements SelectorParser<T> {

  private PaginationStrategy paginationStrategy;
  private ItemSelector<T> itemSelector;
  private List<T> result;

  public JsoupParserExecutor(ItemSelector<T> itemSelector) {
    this.result = new ArrayList<>();
    this.itemSelector = itemSelector;
  }

  public JsoupParserExecutor(PaginationStrategy paginationStrategy, ItemSelector<T> itemSelector) {
    this(itemSelector);
    this.paginationStrategy = paginationStrategy;
  }

  public List<T> executeSelector() {
    validate();

    String nextUrl = paginationStrategy.getSearchResultUrl();

    while (!nextUrl.equals(paginationStrategy.getRootUrl())) {
      Document currentDocument = getDocument(nextUrl);
      Elements items = getElements(currentDocument);

      List<T> currentResult = fillResult(items);
      result.addAll(currentResult);

      nextUrl = getNextPageUrl(currentDocument);
    }

    return result;
  }

  private String getNextPageUrl(Document document) {
    PaginationSelector selector = paginationStrategy.getPaginationSelector();
    String concatenatedUrl = "";

    if (paginationStrategy.getPaginationSelector().getAttributeName() == null) {
      concatenatedUrl += document.select(selector.getPaginationTagSelector());
    } else {
      concatenatedUrl += document
          .select(selector.getPaginationTagSelector())
          .attr(selector.getAttributeName());
    }

    return paginationStrategy.getRootUrl() + concatenatedUrl;
  }

  private void validate() {
    Class<T> referenceType = itemSelector.getClassType();
    itemSelector.getSelectors()
        .forEach(s -> FieldValidator.validateClassHasField(referenceType, s.getFieldName()));
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

  private List<T> fillResult(Elements elements) {
    List<T> result = new ArrayList<>();

    for (Element element : elements) {
      T object = instantiateObject(element);
      result.add(object);
    }

    return result;
  }

  private T instantiateObject(Element element) {
    T object = InstanceFactory.newInstance(itemSelector.getClassType());

    for (FieldSelector selector : itemSelector.getSelectors()) {
      String rawContent = element.select(selector.getCssQuery()).text();
      InstanceSetter.setField(object, selector.getFieldName(), rawContent);
    }

    return object;
  }
}
