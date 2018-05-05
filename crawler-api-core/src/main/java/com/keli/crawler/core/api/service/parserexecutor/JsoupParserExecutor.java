package com.keli.crawler.core.api.service.parserexecutor;

import com.keli.crawler.core.api.factory.InstanceFactory;
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

  private Elements items;
  private Document document;

  public JsoupParserExecutor(PaginationStrategy paginationStrategy, ItemSelector<T> itemSelector) {
    this.result = new ArrayList<>();
    this.itemSelector = itemSelector;
    this.paginationStrategy = paginationStrategy;
  }

  public List<T> executeSelector() {
    validate();
    fillDocument();
    fillItems();
    fillResult();

    return result;
  }

  private void validate() {
    Class<T> referenceType = itemSelector.getClassType();
    itemSelector.getSelectors()
        .forEach(s -> FieldValidator.validateClassHasField(referenceType, s.getFieldName()));
  }

  private void fillDocument() {
    String rootUrl = paginationStrategy.getSearchResultUrl();
    try {
      document = Jsoup.connect(rootUrl).get();
    } catch (IOException e) {
      throw new FailedConnectionException("Cannot connect to the given url", e);
    }
  }

  private void fillItems() {
    items = document.select(itemSelector.getCssQuery());
  }

  private void fillResult() {
    for (Element element : items) {
      T object = instantiateObject(element);
      result.add(object);
    }
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
