package org.testcraft.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) { super(driver); }


    public HomePage navigateTo() {
        driver.manage().window().maximize();
        driver.get("https://www.thetrainline.com/");
        return new HomePage(driver);
    }

    public void checkPageTitle() {
        driver.getTitle().contains("Trainline");
    }

    public void enterOriginStation(String arg1) throws Throwable {
        WebElement origin = driver.findElement(By.id("originStation"));
        origin.sendKeys(arg1);
    }

    public void enterDestinationStation (String arg1) throws Throwable {
        WebElement destination = driver.findElement(By.id("destinationStation"));
        destination.sendKeys(arg1);
    }

    public void checkOneWay() throws Throwable {
        if(driver.findElement(By.id("journey-type-single")).isSelected()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public void returnSelected() throws Throwable {
        WebElement returnButton = driver.findElement(By.id("journey-type-return"));
        returnButton.click();
        if (driver.findElement(By.id("journey-type-return")).isSelected()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public void selectTomorrowAndNextDay() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[1]/div/div[1]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]")).click();
    }


    public void selectArriveBy() throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("outDepartOrArrive")));
        dropdown.selectByIndex(1);

    }

    public void pressSearch() throws Throwable {
        WebElement sendButton = driver.findElement(By.id("submitButton"));
        sendButton.click();

    }
}

