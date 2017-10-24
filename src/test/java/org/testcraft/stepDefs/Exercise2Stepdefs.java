package org.testcraft.stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise2Stepdefs {

    public WebDriver driver;
    public WebDriverWait waiter;

    public Exercise2Stepdefs() {
        driver = Hooks.driver;
    }


    @Given("^I'm on https://www\\.thetrainline\\.com/ main page$")
    public void openTrainlinePage () throws Throwable {
        driver.manage().window().maximize();
        driver.get("https://www.thetrainline.com/");
        Boolean pageTitle = driver.getTitle().contains("Trainline");
    }

    @When("^I enter origin station \"([^\"]*)\"$")
    public void enterOriginStation (String arg1) throws Throwable {
        WebElement origin = driver.findElement(By.id("originStation"));
        origin.sendKeys(arg1);
    }

    @And("^I enter destination station \"([^\"]*)\"$")
    public void enterDestinationStation (String arg1) throws Throwable {
        WebElement destination = driver.findElement(By.id("destinationStation"));
        destination.sendKeys(arg1);
    }

    @And("^One way is selected$")
    public void checkOneWay() throws Throwable {
        if(driver.findElement(By.id("journey-type-single")).isSelected()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    @And("^I choose to Arrive by$")
    public void selectArriveBy() throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("outDepartOrArrive")));
        dropdown.selectByIndex(1);

    }

    @When("^I click search$")
    public void pressSearch() throws Throwable {
        WebElement sendButton = driver.findElement(By.id("submitButton"));
        sendButton.click();

    }

    @Then("^train times should be displayed$")
    public void displayTrainTickets() throws Throwable {
        Thread.sleep(3000);
        WebElement tickets = driver.findElement(By.id("tickets"));
        Assert.assertTrue(tickets.isDisplayed());
    }

    @And("^I should have the option to change my choices$")
    public void cboiceButtonPresent() throws Throwable {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"changeJourney\"]"));
        Boolean buttonExists = button.isDisplayed();
    }
}


