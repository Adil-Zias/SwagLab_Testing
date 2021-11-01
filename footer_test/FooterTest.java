package com.swaglab.footer_test;

import com.swaglab.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FooterTest extends BaseClass {
    public void roobotImageIsDisplayed() throws InterruptedException {
        setUp("chrome");
        loginAsAdmin();
        WebElement footerroobtsimg = driver.findElement(By.cssSelector("#page_wrapper > footer > img"));
        String result = footerroobtsimg.isDisplayed() ? "Footer robots is displayed" : "footer robots is not displayed";
        System.out.println(result);
        ending();

    }
}
