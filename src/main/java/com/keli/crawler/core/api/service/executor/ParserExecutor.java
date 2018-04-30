package com.keli.crawler.core.api.service.executor;

import com.keli.crawler.core.api.example.domain.House;
import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.selector.item.HtmlItemSelector;
import com.keli.crawler.core.api.service.utils.InstanceSetter;
import com.keli.crawler.core.api.service.validator.FieldValidator;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserExecutor {

  private Elements items;

  private List<House> result;
  private Document document;
  private HtmlItemSelector itemSelector;

  public ParserExecutor(Document document, HtmlItemSelector itemSelector) {
    this.result = new ArrayList<>();
    this.document = document;
    this.itemSelector = itemSelector;
  }

  public List<House> executeSelector() {
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
    List<FieldSelector> selectors = itemSelector.getSelectors();
    for (Element element : items) {
      House object = new House();

      for (FieldSelector selector : selectors) {
        Object fieldContent = selector.execute(element);
        InstanceSetter.setField(object, selector.getFieldName(), fieldContent);
      }

      result.add(object);
    }
  }

}
