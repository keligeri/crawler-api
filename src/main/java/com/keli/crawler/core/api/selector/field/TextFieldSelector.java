package com.keli.crawler.core.api.selector;

import com.keli.crawler.core.api.service.validator.SelectorValidator;
import java.util.HashMap;
import java.util.Map;

public class TextSelector implements Selector {

  private final SelectorValidator selectorValidator = new SelectorValidator();

  private Class<?> classType;
  private Map<String, String> selectors = new HashMap<>();

  public TextSelector(Class classType) {
    this.classType = classType;
  }

  @Override
  public void addSelector(String fieldName, String selector) {
    selectorValidator.validateSelector(fieldName, selector);

    selectors.put(fieldName, selector);
  }

  @Override
  public Map<String, String> getSelectors() {
    return selectors;
  }

  @Override
  public Class<?> getClassType() {
    return classType;
  }
}
