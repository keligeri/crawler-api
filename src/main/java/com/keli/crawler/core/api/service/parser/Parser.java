package com.keli.crawler.core.api.service.parser;

public interface Parser {

  void parseItems();

//  void saveItems(SaveStrategy saveStrategy);  // something like that
  void saveItems();
}
