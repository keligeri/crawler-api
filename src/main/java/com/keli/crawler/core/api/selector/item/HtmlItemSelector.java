package com.keli.crawler.core.api.selector.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HtmlItemSelector implements ItemSelector {

  private Class<?> classType;
  private String tagCssQuery;
}
