package cucumberJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogo() {
        return driver.findElement(By.className("header__logo-container"));
    }

    public WebElement getHereInCookieBlockButton() {
        return driver.findElement(By.className("cookie-disclaimer__description"))
                .findElement(By.tagName("p")).findElement(By.tagName("a"));
    }

    public WebElement getRollOver() {
        return driver.findElement(By.className("rollover-tiles-ui"));
    }

    public WebElement getMainBlock() {
        return driver.findElement(By.id("main"));
    }

    public WebElement getSearchButtonAtHeader() {
        return driver.findElement(By.className("header-search__button"));
    }
}
