package com.keli.cawler.core.api;

import com.keli.cawler.core.api.domain.House;
import com.keli.crawler.core.api.pagination.selector.PaginationSelector;
import com.keli.crawler.core.api.pagination.strategy.HtmlPaginationStrategy;
import com.keli.crawler.core.api.selector.field.DoubleFieldSelector;
import com.keli.crawler.core.api.selector.field.TextFieldSelector;
import com.keli.crawler.core.api.selector.item.HtmlItemSelector;
import com.keli.crawler.core.api.service.parser.HtmlParser;

public class DemoApp {

  private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html?aid=304142&label=gen173nr-1FCAEoggJCAlhYSDNYBGhniAEBmAEuwgEKd2luZG93cyAxMMgBDNgBAegBAfgBC5ICAXmoAgM&sid=f8547b950c5412d186733360b0e691d5&checkin_month=7&checkin_monthday=2&checkin_year=2018&checkout_month=7&checkout_monthday=6&checkout_year=2018&class_interval=1&dest_id=-372490&dest_type=city&from_sf=1&group_adults=2&group_children=0&label_click=undef&no_rooms=1&raw_dest_type=city&room1=A%2CA&sb_price_type=total&search_selected=1&src=index&src_elem=sb&ss=Barcelona%2C%20Catalonia%2C%20Spain&ss_raw=Barcelona&ssb=empty&rows=16";

  public static void main(String[] args) {
    PaginationSelector paginationSelector = PaginationSelector.builder()
        .paginationTagSelector("sr_pagination_link")
        .build();

    HtmlPaginationStrategy paginationStrategy = new HtmlPaginationStrategy(
        "http://booking.com", BOOKING_URL, paginationSelector);

    HtmlItemSelector htmlItemSelector = new HtmlItemSelector(House.class, ".sr_item");
    htmlItemSelector.addSelector(new TextFieldSelector("name", ".sr-hotel__name"));
    htmlItemSelector.addSelector(new DoubleFieldSelector("price", "b"));

    HtmlParser parser = new HtmlParser(paginationStrategy, htmlItemSelector);
    parser.parseItems();
  }
}
