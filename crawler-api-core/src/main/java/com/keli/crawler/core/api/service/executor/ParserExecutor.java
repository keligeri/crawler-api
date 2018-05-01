package com.keli.crawler.core.api.service.executor;

import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.factory.InstanceFactory;
import com.keli.crawler.core.api.selector.item.ItemSelector;
import com.keli.crawler.core.api.utils.InstanceSetter;
import com.keli.crawler.core.api.validator.FieldValidator;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserExecutor<T> {

  private Elements items;

  private List<T> result;
  private Document document;
  private ItemSelector itemSelector;

  public ParserExecutor(Document document, ItemSelector itemSelector) {
    this.result = new ArrayList<>();
    this.document = document;
    this.itemSelector = itemSelector;
  }

  public List<T> executeSelector() {
    validate();
    fillItems();
    fillResult();

    return result;
  }

  private void validate() {
    Class<?> referenceType = itemSelector.getClassType();
    itemSelector.getSelectors()
        .forEach(s -> FieldValidator.validateClassHasField(referenceType, s.getFieldName()));
  }

  private void fillItems() {
    items = document.select(itemSelector.getTagCssQuery());
  }

  private void fillResult() {
    for (Element element : items) {
      T object = instantiateObject(element);
      result.add(object);
    }
  }

  private T instantiateObject(Element element) {
    T object = InstanceFactory.newInstance((Class<T>) itemSelector.getClassType());
    List<FieldSelector> selectors = itemSelector.getSelectors();

    for (FieldSelector selector : selectors) {
      Object fieldContent = selector.execute(element);
      InstanceSetter.setField(object, selector.getFieldName(), fieldContent);
    }

    return object;
  }
}
