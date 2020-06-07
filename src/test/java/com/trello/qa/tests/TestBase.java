package com.trello.qa.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    AppiumDriver appiumDriver;

    @BeforeMethod
    public void setUp () throws MalformedURLException {
DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("deviceName", "Moto G");
        capabilities.setCapability("appPackage","com.trello");
        capabilities.setCapability("appActivity", "home.HomeActivity");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app",
                "C:/Users/User/IdeaProjects/trelloMobile/src/test/resources/Trello_com.trello.apk");

       /* capabilities.setCapability("app",
                "src/test/resources/Trello_com.trello.apk");*/


        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }

    @AfterMethod
    public  void tearDown() throws InterruptedException {
        /*Thread.sleep(10000);
        appiumDriver.quit();*/

    }
}
