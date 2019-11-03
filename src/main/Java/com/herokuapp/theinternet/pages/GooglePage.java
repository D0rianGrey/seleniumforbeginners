package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePageObject {
    private String pageUrl = "http://google.com.ua";

    public GooglePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open HoversPage with it's url */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }


}
