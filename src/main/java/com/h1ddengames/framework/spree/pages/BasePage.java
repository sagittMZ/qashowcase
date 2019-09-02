package com.h1ddengames.framework.spree.pages;

import com.h1ddengames.framework.CommonSeleniumTasks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*
Contains navigation methods.
Since navigation is the same across all pages, the elements contained here will
always be used by every other page class.
*/
public class BasePage extends CommonSeleniumTasks {
    public String baseURL = "http://spree.shiftedtech.com";

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected JavascriptExecutor driverJSExecutor;

    @Override protected WebDriver getDriver() { return driver; }
    @Override protected WebDriverWait getDriverWait() { return driverWait; }
    @Override protected JavascriptExecutor getDriverJSExecutor() { return driverJSExecutor; }

    public void goToHomePage() {
        clickElement(By.linkText("Home"));
    }
    public void goToLoginPage() {
        clickElement(By.linkText("Login"));
    }
    public void goToCart() {
        clickElement(By.id("link-to-cart"));
    }

    public void logOut() {
        clickElement(By.linkText("Logout"));
        checkSignoutSuccessMessage();
    }

    public void checkSignoutSuccessMessage() {
        WebElement signoutSuccessMessage = driver.findElement(
                By.xpath("//div[@id='content']/div[contains(text(),'Signed out successfully.')]"));
        Assert.assertEquals(signoutSuccessMessage.getText(), "Signed out successfully.");
    }
}
