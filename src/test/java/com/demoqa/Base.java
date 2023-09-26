package com.demoqa;

import org.openqa.selenium.WebDriver;

public class Base extends BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}

