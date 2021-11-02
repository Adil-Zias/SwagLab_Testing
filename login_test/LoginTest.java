package com.swaglab.login_test;

import com.swaglab.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {



    @Test
    public void loginWithValid_Test() throws InterruptedException {

        login("standard_user", "secret_sauce");
        String currentUrl = driver.getCurrentUrl();
        String expectedURl = "https://www.saucedemo.com/inventory.html";
        String result = currentUrl.equals(expectedURl) ? "login successfully" : "test failed, login failed";
        System.out.println(result);
        Assert.assertEquals(currentUrl, expectedURl);


    }

    @Test
    public void loginWithInValid_test() throws InterruptedException {

        login("bs_user", "bs_sauce");
        WebElement alertMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error"));
        boolean displayed = alertMessage.isDisplayed();
        String invalidMessage = displayed ? "invalid login alert is showing" : "invalid login messages is not showing";
        System.out.println(invalidMessage);
        Assert.assertTrue(displayed);

    }

    @Test
    public void loginWithInValidpassword_test() throws InterruptedException {

        login("standard_user", "bs_sauce");
        WebElement alertMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errormessage = alertMessage.getText();
        String expactedMessage = "Epic sadface: Username and password do not match any user in this service";
        String InvalidPasswordResult = errormessage.equals(expactedMessage) ? "invalid password error is showing" : "invalid password error is not showing";
        System.out.println(InvalidPasswordResult);
        Assert.assertEquals(errormessage, expactedMessage);


    }


    }




