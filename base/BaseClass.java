package com.swaglab.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseClass {
    String URL = "https://www.saucedemo.com";
    String chromeBrowser = "D:\\src\\swaglabs\\src\\drivers\\chromedriver.exe";
    String firefoxBrowser = "D:\\src\\swaglabs\\src\\drivers\\geckodriver.exe";
    public WebDriver driver;

    By username_locator = By.cssSelector("#user-name");
    By password_locator = By.cssSelector("#password");
    By login_button_locator = By.cssSelector("#login-button");

    public void setUp(String browser){
        switch (browser) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", chromeBrowser);
                driver = new ChromeDriver();
                System.out.println("Running on: " + browser);

            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", firefoxBrowser);
                driver = new FirefoxDriver();
                System.out.println("Running on : " + browser);

            }
            default -> System.out.println(browser + "is not supported");
        }
        driver.get(URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    public void ending() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    public void login(String username, String password){
        WebElement username_box = driver.findElement(username_locator);
        WebElement password_box = driver.findElement(password_locator);
        WebElement loggin_button = driver.findElement(login_button_locator);

        username_box.sendKeys(username);
        password_box.sendKeys(password);
        loggin_button.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void loginAsAdmin(){
        login("standard_user", "secret_sauce");
    }


}
