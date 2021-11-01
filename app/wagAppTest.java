package com.swaglab.app;

import com.swaglab.footer_test.FooterTest;
import com.swaglab.login_test.LoginTest;

public class wagAppTest {
    public static void main(String[] args) throws InterruptedException {

        FooterTest footerTest = new FooterTest();
        footerTest.roobotImageIsDisplayed();


        LoginTest loginTest = new LoginTest();
        loginTest.loginWithValid_Test();
        loginTest.loginWithInValid_test();
        loginTest.loginWithInValidpassword_test();
    }

}
