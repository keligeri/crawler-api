package com.keli.crawler.core.api.service.parser;

import java.util.List;

public interface Executor<T> {

  List<T> parseItems();

  void saveItems();
}
