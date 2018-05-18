package com.keli.crawler.core.api.service.parser.jsoupparser.utils;

import com.keli.crawler.core.api.factory.InstanceFactory;
import com.keli.crawler.core.api.selector.field.FieldSelector;
import com.keli.crawler.core.api.selector.item.ItemSelector;
import com.keli.crawler.core.api.utils.InstanceSetter;
import org.jsoup.nodes.Element;

public class ObjectFactory {

  public static <T> T newObject(Element element, ItemSelector<T> itemSelector) {
    T object = InstanceFactory.newInstance(itemSelector.getClassType());

    for (FieldSelector selector : itemSelector.getSelectors()) {
      String rawContent = element.select(selector.getCssQuery()).text();
      InstanceSetter.setField(object, selector.getFieldName(), rawContent);
    }

    return object;
  }
}
