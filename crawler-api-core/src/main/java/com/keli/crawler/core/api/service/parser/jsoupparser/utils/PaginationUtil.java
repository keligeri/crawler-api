package com.keli.crawler.core.api.service.parser.jsoupparser.utils;

import com.keli.crawler.core.api.pagination.selector.PaginationSelector;
import com.keli.crawler.core.api.pagination.strategy.PaginationStrategy;
import org.jsoup.nodes.Document;

public class PaginationUtil {

  public static String getNextPageUrl(Document document, PaginationStrategy paginationStrategy) {
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
}
