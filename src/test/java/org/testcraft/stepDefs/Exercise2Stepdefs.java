package org.testcraft.stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcraft.Pages.HomePage;
import org.testcraft.Pages.TimetablePage;

public class Exercise2Stepdefs {

    public WebDriver driver;
    public WebDriverWait waiter;
    private HomePage hp = new HomePage(driver);
    private TimetablePage tt = new TimetablePage(driver);



    public Exercise2Stepdefs()
    { driver = Hooks.driver;
    }

    @Given("^I'm on https://www\\.thetrainline\\.com/ main page$")
    public void openTrainlinePage () throws Throwable {
        hp = new HomePage(driver);
        hp.navigateTo();
        hp.checkPageTitle();
    }

    @When("^I enter origin station \"([^\"]*)\"$")
    public void enterOriginStation (String arg1) throws Throwable {
        hp.enterOriginStation(arg1);
    }

    @And("^I enter destination station \"([^\"]*)\"$")
    public void enterDestinationStation (String arg1) throws Throwable {
        hp.enterDestinationStation(arg1);
    }

    @And("^One way is selected$")
    public void checkOneWay() throws Throwable {
        hp.checkOneWay();
    }

    @And("^I choose to Arrive by$")
    public void selectArriveBy() throws Throwable {
        hp.selectArriveBy();
    }

    @When("^I click search$")
    public void pressSearch() throws Throwable {
        hp.pressSearch();
    }

    @Then("^train times should be displayed$")
    public void displayTrainTickets() throws Throwable {
        tt = new TimetablePage(driver);
        tt.displayTrainTickets();
    }

    @And("^I should have the option to change my choices$")
    public void cboiceButtonPresent() throws Throwable {
        tt.choiceButtonPresent();
    }
}


