package com.keli.crawler.core.api.pagination.selector;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaginationSelector {

  private String paginationTagSelector;
}
