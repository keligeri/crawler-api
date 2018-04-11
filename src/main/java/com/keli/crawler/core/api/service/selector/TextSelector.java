package com.keli.crawler.core.api.service.selector;

import com.keli.crawler.core.api.service.validator.SelectorValidator;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class TextSelector implements Selector {

  @Getter
  private Class<?> classType;

  @Getter
  private Map<String, String> selectors = new HashMap<>();

  private SelectorValidator selectorValidator;

  public TextSelector(Class classType) {
    this.classType = classType;
  }

  @Override
  public void addSelector(String fieldName, String selector) {
//    selectorValidator.validateSelector(fieldName, selector);

    selectors.put(fieldName, selector);
  }
}
