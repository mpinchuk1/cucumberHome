package cucumberJava;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.internal.matchers.StringContains.containsString;

public class MyStepdefs {

    private static final String EPAM_URL = "http://www.epam.com/";

    WebDriver driver = null;

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @When("^Press Tab$")
    public void pressTab() {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.TAB).build().perform();
    }

    @Given("^I open the browser$")
    public void iHaveOpenTheBrowser() {
        driver = new ChromeDriver();
    }

    @When("^I open Epam website$")
    public void iOpenEpamWebsite() {
        driver.navigate().to(EPAM_URL);
    }

    @Then("^Logo in header should be clickable$")
    public void logoInHeaderShouldBeClickable() {
        WebElement logo = driver.findElement(By.className("header__logo-container"));
        assertTrue(logo.isDisplayed());
        assertEquals(EPAM_URL, logo.getAttribute("href"));
    }

    @When("^I open How we do it page$")
    public void iOpenHowWeDoItPage() {
        driver.navigate().to("https://www.epam.com/how-we-do-it");
    }

    @Then("^How we do it title should be visible and has valid text$")
    public void howWeDoItTitleShouldBeVisibleAndHasValidText() {
        WebElement title = driver.findElement(By.className("title")).findElement(By.tagName("h1"));
        assertTrue(title.isDisplayed());
        assertThat(title.getText(), containsString("How We Do It"));
    }

    @Then("^Cookies banner button here has valid href$")
    public void cookiesBannerButtonHasValidHref() {
        WebElement hereButton = driver.findElement(By.className("cookie-disclaimer__description"))
                .findElement(By.tagName("p")).findElement(By.tagName("a"));
        assertEquals("https://www.epam.com/cookie-policy", hereButton.getAttribute("href"));
    }

    @Then("^Rollover tiles block should be visible$")
    public void rolloverTilesBlockShouldBeVisible() {
        WebElement rolloverBlock = driver.findElement(By.className("rollover-tiles-ui"));
        assertTrue(rolloverBlock.isDisplayed());
    }

    @Then("^Main is visible$")
    public void mainIsVisible() {
        WebElement main = driver.findElement(By.id("main"));
        assertTrue(main.isDisplayed());
    }

    @When("^I open Our work page$")
    public void iOpenOurWorkPage() {
        driver.navigate().to("https://www.epam.com/our-work");
    }

    @Then("^In this section is not visible$")
    public void inThisSectionHasValidText() {
        WebElement inThisSection = driver.findElement(By.cssSelector(".in-page-navigation__trigger-title"));
        assertFalse(inThisSection.isDisplayed());
    }

    @Then("^Filter by should have valid text$")
    public void filterByShouldHaveValidText() {
        WebElement filterBy = driver.findElement(By.className("detail-pages-filter__top-panel-holder"));
        assertThat(filterBy.getText(), containsString("FILTER BY"));
    }

    @Then("^Search button at the header should be visible$")
    public void searchButtonAtTheHeaderShouldBeVisible() {
        WebElement searchButton = driver.findElement(By.className("header-search__button"));
        assertTrue(searchButton.isDisplayed());
    }
}
