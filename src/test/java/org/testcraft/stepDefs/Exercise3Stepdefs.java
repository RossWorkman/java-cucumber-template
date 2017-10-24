package org.testcraft.stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise3Stepdefs {

    public WebDriver driver;
    public WebDriverWait waiter;

    public Exercise3Stepdefs() {
        driver = Hooks.driver;
    }

    @Given("^I'm on the https://www\\.thetrainline\\.com/ main page$")
    public void openTrainlinePage () throws Throwable {
        driver.manage().window().maximize();
        driver.get("https://www.thetrainline.com/");
        Boolean pageTitle = driver.getTitle().contains("Trainline");
    }

    @When("^I enter the origin station \"([^\"]*)\"$")
    public void enterOriginStation (String arg1) throws Throwable {
        WebElement origin = driver.findElement(By.id("originStation"));
        origin.sendKeys(arg1);
    }

    @And("^I enter the destination station \"([^\"]*)\"$")
    public void enterDestinationStation (String arg1) throws Throwable {
        WebElement destination = driver.findElement(By.id("destinationStation"));
        destination.sendKeys(arg1);
    }

    @And("^I select return$")
    public void returnSelected() throws Throwable {
        WebElement returnButton = driver.findElement(By.id("journey-type-return"));
        returnButton.click();
        if(driver.findElement(By.id("journey-type-return")).isSelected()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    @And("^I select Tomorrow and Next day$")
    public void selectTomorrowAndNextDay() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[1]/div/div[1]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]")).click();

    }

    @When("^I click search button$")
    public void pressSearch() throws Throwable {
        WebElement sendButton = driver.findElement(By.id("submitButton"));
        sendButton.click();

    }

    @Then("^the train times should be displayed$")
    public void displayTrainTickets() throws Throwable {
        Thread.sleep(3000);
        WebElement tickets = driver.findElement(By.id("tickets"));
        Assert.assertTrue(tickets.isDisplayed());
    }

    @And("^I should have option to change my choices$")
    public void cboiceButtonPresent() throws Throwable {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"changeJourney\"]"));
        Boolean buttonExists = button.isDisplayed();
    }
}


