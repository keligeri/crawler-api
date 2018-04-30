package com.keli.crawler.core.api.selector.field;

import org.jsoup.nodes.Element;

public class TextFieldSelector extends FieldSelector<String> {

  public TextFieldSelector(String fieldName, String cssQuery) {
    super(fieldName, cssQuery);
  }

  public String execute(Element element) {
    return element.select(cssQuery).text();
  }
}
