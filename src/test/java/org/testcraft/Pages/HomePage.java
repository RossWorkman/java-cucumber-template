package org.testcraft.Pages;
import cucumber.api.java.ca.Cal;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) { super(driver); }

    private String Today;

    public HomePage navigateTo() {
        driver.manage().window().maximize();
        driver.get("https://www.thetrainline.com/");
        return new HomePage(driver);
    }

    public void checkPageTitle() {
        driver.getTitle().contains("Trainline");
        driver.findElement(By.cssSelector("#master > div.cookie-policy > div > button > span")).click();
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

    public void pickFutureOutDate(int days, String month, int year){
        int selected = 0;
        Calendar today = Calendar.getInstance();
        int dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int currentYear = today.get(Calendar.YEAR);
        Assert.assertFalse(currentYear > year);
        driver.findElement(By.id("outDate")).click();
        while (selected < 1) {
            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            if (currentMonth.equals(month)) {
                WebElement calendars = driver.findElement(By.id("ui-datepicker-div"));
                List<WebElement> columns = calendars.findElements(By.tagName("td"));
                for (WebElement cell : columns) {
                    if (cell.getText().equals("" + days + "")) {
                        cell.click();
                        selected++;
                    }
                }
            } else {
                driver.findElement(By.cssSelector("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-last > div > a > span")).click();
                continue;
            }
        }
    }

    public void pickFutureInDate (int days, String month, int year) throws InterruptedException {
        int selected = 0;
        Calendar today = Calendar.getInstance();
        int dayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int currentYear = today.get(Calendar.YEAR);
        Assert.assertFalse(currentYear > year);
        driver.findElement(By.id("returnDate")).click();
        while (selected < 1) {
            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            if (currentMonth.equals(month)) {
                WebElement calendars = driver.findElement(By.id("ui-datepicker-div"));
                List<WebElement> columns = calendars.findElements(By.tagName("td"));
                for (WebElement cell : columns) {
                    if (cell.getText().equals("" + days + "")) {
                        cell.click();
                        selected++;
                    }
                }
            } else {
                driver.findElement(By.cssSelector("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-last > div > a > span")).click();
                continue;
            }
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

