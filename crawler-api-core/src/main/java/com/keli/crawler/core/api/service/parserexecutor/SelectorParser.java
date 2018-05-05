package com.keli.crawler.core.api.service.parserexecutor;

import java.util.List;

public interface SelectorParser<T> {

  List<T> executeSelector();
}
