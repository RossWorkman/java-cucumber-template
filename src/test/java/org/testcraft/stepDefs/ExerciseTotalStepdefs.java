package org.testcraft.stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcraft.Pages.HomePage;
import org.testcraft.Pages.TimetablePage;

public class ExerciseTotalStepdefs {

    public WebDriver driver;
    public WebDriverWait waiter;
    private HomePage hp = new HomePage(driver);
    private TimetablePage tt = new TimetablePage(driver);



   public ExerciseTotalStepdefs()
    { driver = Hooks.driver;
    }

    @Given("^I'm on the https://www.thetrainline.com/ main page$")
    public void openTrainlinePage () throws Throwable {
        hp = new HomePage(driver);
        hp.navigateTo();
        hp.checkPageTitle();
    }

    @When("^I enter the origin station \"([^\"]*)\"$")
    public void enterOriginStation (String arg1) throws Throwable {
        hp.enterOriginStation(arg1);
    }

    @When("^I enter the destination station \"([^\"]*)\"$")
    public void enterDestinationStation (String arg1) throws Throwable {
        hp.enterDestinationStation(arg1);
    }

    @When("^I click the search button$")
    public void pressSearch() throws Throwable {
        hp.pressSearch();
    }

    @Then("^the train times should be displayed$")
    public void displayTrainTickets() throws Throwable {
        tt = new TimetablePage(driver);
        tt.displayTrainTickets();
    }

    @And("^One way is selected$")
    public void checkOneWay() throws Throwable {
        hp.checkOneWay();
    }

    @And("^I choose to Arrive by$")
    public void selectArriveBy() throws Throwable {
        hp.selectArriveBy();
    }

    @And("^I select return$")
    public void checkReturn() throws Throwable {
        hp.returnSelected();
    }

    @When("^I select tomorrow and next day$")
    public void selectTomorrow() throws Throwable {
        hp.selectTomorrowAndNextDay();
    }

    @And("^I select a date in the future$")
    public void selectFutureDate() throws Throwable {
        hp.pickFutureOutDate(5, "November", 2017);
        hp.pickFutureReturnDate(1, "April", 2018);
    }

    @And("^I pick 2 Adults and 2 Children$")
    public void choosePassengers () throws Throwable {
        hp.multiplePassengers(2,2);
    }

    @And("^I choose to return on the same day$")
    public void sameDayReturn () throws Throwable {
        hp.clickSameDay();
    }

    @And("^I choose to return hours later$")
    public void returnLater () {
        hp.addHoursToReturn(2);
    }
}


