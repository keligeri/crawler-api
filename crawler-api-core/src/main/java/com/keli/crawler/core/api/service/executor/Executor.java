package com.keli.crawler.core.api.service.executor;

import java.util.List;

public interface Executor<T> {

  List<T> parseItems();

  void saveItems();
}
