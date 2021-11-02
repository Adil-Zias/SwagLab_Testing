package com.swaglab.footer_test;

import com.swaglab.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseClass {

    @Test
    public void roobotImageIsDisplayed() throws InterruptedException {

        loginAsAdmin();
        WebElement footerroobtsimg = driver.findElement(By.cssSelector("#page_wrapper > footer > img"));
        String result = footerroobtsimg.isDisplayed() ? "Footer robots is displayed" : "footer robots is not displayed";
        System.out.println(result);
        Assert.assertTrue(footerroobtsimg.isDisplayed());

    }
}
