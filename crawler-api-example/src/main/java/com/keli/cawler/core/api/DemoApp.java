package com.keli.cawler.core.api;

import com.keli.cawler.core.api.domain.House;
import com.keli.crawler.core.api.pagination.selector.PaginationSelector;
import com.keli.crawler.core.api.pagination.strategy.HtmlPaginationStrategy;
import com.keli.crawler.core.api.selector.field.DefaultFieldSelector;
import com.keli.crawler.core.api.selector.item.HtmlItemSelector;
import com.keli.crawler.core.api.service.parser.jsoupparser.JsoupParser;
import com.keli.crawler.core.api.service.parser.Parser;
import com.keli.crawler.core.api.service.executor.HtmlExecutor;
import java.util.List;

public class DemoApp {

  private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html?aid=304142&label=gen173nr-1FCAEoggJCAlhYSDNYBGhniAEBmAEuwgEKd2luZG93cyAxMMgBDNgBAegBAfgBC5ICAXmoAgM&sid=f8547b950c5412d186733360b0e691d5&checkin_month=5&checkin_monthday=23&checkin_year=2018&checkout_month=5&checkout_monthday=28&checkout_year=2018&city=-850553&class_interval=1&dest_id=-870672&dest_type=city&from_sf=1&group_adults=1&group_children=0&label_click=undef&no_rooms=1&raw_dest_type=city&room1=A&sb_price_type=total&search_selected=1&src=searchresults&src_elem=sb&ss=Zalaegerszeg%2C%20Zala%2C%20Hungary&ss_raw=Zalaeger&ssb=empty&ssne_untouched=Budapest&rows=50";

  private static final String SZALLAS_URL = "https://szallas.hu/budapest?checkin=2018-06-18&checkout=2018-06-24&search=Budapest(Budapest%3B7)";

  public static void main(String[] args) {
    crawlSzallas();
//    crawlBooking();
  }

  private static void crawlBooking() {
    PaginationSelector paginationSelector = new PaginationSelector(".paging-next", "href");

    HtmlPaginationStrategy paginationStrategy = new HtmlPaginationStrategy(
        "http://booking.com", BOOKING_URL, paginationSelector);

    HtmlItemSelector<House> htmlItemSelector = new HtmlItemSelector<>(House.class, ".sr_item");
    htmlItemSelector.addSelector(new DefaultFieldSelector("name", ".sr-hotel__name"));
    htmlItemSelector.addSelector(new DefaultFieldSelector("price", "b"));

    Parser<House> jsoupParser = new JsoupParser<>(paginationStrategy, htmlItemSelector);

    HtmlExecutor<House> htmlExecutor = new HtmlExecutor<>(jsoupParser);
    List<House> houses = htmlExecutor.parseItems();

    houses.forEach(System.out::println);
    System.out.println(houses.size());
  }

  private static void crawlSzallas() {
    PaginationSelector paginationSelector = new PaginationSelector(".pagination-right", "href");

    HtmlPaginationStrategy paginationStrategy = new HtmlPaginationStrategy(
        "http://szallas.hu", SZALLAS_URL, paginationSelector);

    HtmlItemSelector<House> htmlItemSelector = new HtmlItemSelector<>(House.class, ".list-element");
    htmlItemSelector.addSelector(new DefaultFieldSelector("name", ".name"));
    htmlItemSelector.addSelector(new DefaultFieldSelector("price", ".final-price"));

    Parser<House> jsoupParser = new JsoupParser<>(
        paginationStrategy, htmlItemSelector);

    HtmlExecutor<House> htmlParser = new HtmlExecutor<>(jsoupParser);
    List<House> houses = htmlParser.parseItems();

    houses.forEach(System.out::println);
    System.out.println(houses.size());
  }
}
