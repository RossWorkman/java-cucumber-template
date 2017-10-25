package org.testcraft.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TimetablePage extends BasePage  {

    public TimetablePage(WebDriver driver) {
        super(driver);
    }

    public void displayTrainTickets() throws Throwable {
        Thread.sleep(2000);
        WebElement tickets = driver.findElement(By.id("tickets"));
        Assert.assertTrue(tickets.isDisplayed());
    }

}
