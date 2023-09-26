package com.demoqa;

public class WebPageAddress extends Base {


    protected final String nameAddressWebSite = "https://demoqa.com/";


    public void openWebSite() {

        driver.get(nameAddressWebSite);
    }
}
