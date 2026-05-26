package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionsExample {

    WebDriver driver;

    @BeforeClass
    void setup()
    {
        System.setProperty("webdriver.chrome.driver",
                "C:\\browser-drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 1)
    void headingTest()
    {
        WebElement heading = driver.findElement(
                By.xpath("//h1"));

        Assert.assertTrue(heading.isDisplayed(),
                "Heading is not displayed");
    }

    @Test(priority = 2)
    void homePageTitle()
    {
        String title = driver.getTitle();

        Assert.assertEquals(title,
                "The Internet",
                "Title is not matched");
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}