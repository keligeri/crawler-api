package com.keli.crawler.core.api.service.parserexecutor;

import java.util.List;

public interface Parser<T> {

  List<T> executeSelector();
}
