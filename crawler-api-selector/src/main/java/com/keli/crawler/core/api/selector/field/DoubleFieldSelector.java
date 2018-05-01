package com.keli.crawler.core.api.selector.field;

import com.keli.crawler.core.api.utils.StringUtils;
import org.jsoup.nodes.Element;

public class DoubleFieldSelector extends FieldSelector<Double> {

  public DoubleFieldSelector(String fieldName, String cssQuery) {
    super(fieldName, cssQuery);
  }

  public Double execute(Element element) {
    String text = element.select(cssQuery).text();
    return StringUtils.getDoubleFromString(text);
  }
}
