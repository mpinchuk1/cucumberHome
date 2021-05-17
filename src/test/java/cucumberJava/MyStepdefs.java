package cucumberJava;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.internal.matchers.StringContains.containsString;

public class MyStepdefs {

    private static final String EPAM_URL = "http://www.epam.com/";
    private static final String HOW_WE_DO_IT_URL = "https://www.epam.com/how-we-do-it";
    private static final String OUR_WORK_URL = "https://www.epam.com/our-work";

    private WebDriver driver;

    @After
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
        MainPage mainPage = new MainPage(driver);
        WebElement logo = mainPage.getLogo();
        assertTrue(logo.isDisplayed());
        assertEquals(EPAM_URL, logo.getAttribute("href"));
    }

    @When("^I open How we do it page$")
    public void iOpenHowWeDoItPage() {
        driver.navigate().to(HOW_WE_DO_IT_URL);
    }

    @Then("^How we do it title should be visible and has valid text$")
    public void howWeDoItTitleShouldBeVisibleAndHasValidText() {
        HowWeDoItPage page = new HowWeDoItPage(driver);
        WebElement title = page.getTitle();
        assertTrue(title.isDisplayed());
        assertThat(title.getText(), containsString("How We Do It"));
    }

    @Then("^Cookies banner button here has valid href$")
    public void cookiesBannerButtonHasValidHref() {
        MainPage page = new MainPage(driver);
        WebElement hereButton = page.getHereInCookieBlockButton();
        assertEquals("https://www.epam.com/cookie-policy", hereButton.getAttribute("href"));
    }

    @Then("^Rollover tiles block should be visible$")
    public void rolloverTilesBlockShouldBeVisible() {
        MainPage page = new MainPage(driver);
        WebElement rolloverBlock = page.getRollOver();
        assertTrue(rolloverBlock.isDisplayed());
    }

    @Then("^Main is visible$")
    public void mainIsVisible() {
        MainPage page = new MainPage(driver);
        WebElement main = page.getMainBlock();
        assertTrue(main.isDisplayed());
    }

    @When("^I open Our work page$")
    public void iOpenOurWorkPage() {
        driver.navigate().to(OUR_WORK_URL);
    }

    @Then("^In this section is not visible$")
    public void inThisSectionHasValidText() {
        OurWorkPage page = new OurWorkPage(driver);
        WebElement inThisSection = page.getInThisSection();
        assertFalse(inThisSection.isDisplayed());
    }

    @Then("^Filter by should have valid text$")
    public void filterByShouldHaveValidText() {
        OurWorkPage page = new OurWorkPage(driver);
        WebElement filterBy = page.getFilterBy();
        assertThat(filterBy.getText(), containsString("FILTER BY"));
    }

    @Then("^Search button at the header should be visible$")
    public void searchButtonAtTheHeaderShouldBeVisible() {
        MainPage page = new MainPage(driver);
        WebElement searchButton = page.getSearchButtonAtHeader();
        assertTrue(searchButton.isDisplayed());
    }
}
