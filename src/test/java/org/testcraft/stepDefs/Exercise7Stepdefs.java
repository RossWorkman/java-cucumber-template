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
import org.testcraft.Pages.HomePage;
import org.testcraft.Pages.TimetablePage;

public class Exercise7Stepdefs {

    public WebDriver driver;
    public WebDriverWait waiter;
    private HomePage hp = new HomePage(driver);
    private TimetablePage tt = new TimetablePage(driver);

    public Exercise7Stepdefs() {
        driver = Hooks.driver;
    }

    @Given("^I'm on the https://www\\.thetrainline\\.com/ main page$")
    public void openTrainlinePage () throws Throwable {
        hp = new HomePage(driver);
        hp.navigateTo();
        hp.checkPageTitle();
    }

    @When("^I enter the origin station \"([^\"]*)\"$")
    public void enterOriginStation (String arg1) throws Throwable {
        hp.enterOriginStation(arg1);
    }

    @And("^I enter the destination station \"([^\"]*)\"$")
    public void enterDestinationStation (String arg1) throws Throwable {
        hp.enterDestinationStation(arg1);
    }

    @And("^I pick return$")
    public void choosePassengers () throws Throwable {
        hp.returnSelected();
    }

    @And("^I choose to return on the same day$")
    public void sameDayReturn () throws Throwable {
        hp.clickSameDay();
    }

    @And("^I choose to return hours later$")
    public void returnLater () {
        hp.addHoursToReturn(2);
    }

    @When("^I click search button$")
    public void pressSearch() throws Throwable {
        hp.pressSearch();
    }

    @Then("^the train times should be displayed$")
    public void displayTrainTickets() throws Throwable {
        tt = new TimetablePage(driver);
        tt.displayTrainTickets();
    }

}


