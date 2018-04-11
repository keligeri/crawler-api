package com.keli.crawler.core.api.service.parser.parserstrategy;

import com.keli.crawler.core.api.service.selector.Selector;

public interface ParserStrategy {

  Selector getSelector();
}
