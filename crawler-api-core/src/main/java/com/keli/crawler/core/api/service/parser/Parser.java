package com.keli.crawler.core.api.service.parser;

import java.util.List;

public interface Parser<T> {

  List<T> executeSelectors();
}
