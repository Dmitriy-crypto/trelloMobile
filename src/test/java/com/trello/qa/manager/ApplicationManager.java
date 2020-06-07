package com.trello.qa.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver appiumDriver;
    //-------------------Variables-------------------------------------
    public static String url = "https://trello.com/";
    public static String email = "dmitriy.stadnikov@yahoo.com";
    public static String password = "75Dmitriy.2013Eva";
    public String x = "23";
    public int numberBoards = 3;// number of boards to creat

    BoardHelper boardHelper;
    TeamHelper teamHelper;
    SessionHelper sessionHelper;
    /* boolean no_team = true;//option selection
     boolean privet_team = true;//option selection not work
     boolean enable_background_random = true;// enable random background selection*/
    int n; //board selection by position in "public void selectPersonalBoardByNumber"


    public void init() throws InterruptedException, MalformedURLException {

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







        teamHelper = new TeamHelper(appiumDriver);
        boardHelper = new BoardHelper(appiumDriver);
        sessionHelper = new SessionHelper(appiumDriver);


        sessionHelper.loginToTrello(email, password);
    }

    public void stop() {

        appiumDriver.quit();
    }

    public BoardHelper getBoardHelper() {

        return boardHelper;
    }

    public TeamHelper getTeamHelper() {

        return teamHelper;
    }

    public SessionHelper getSessionHelper() {

        return sessionHelper;
    }
}
