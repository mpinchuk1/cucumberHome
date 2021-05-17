package cucumberJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OurWorkPage {

    private final WebDriver driver;

    public OurWorkPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInThisSection() {
        return driver.findElement(By.cssSelector(".in-page-navigation__trigger-title"));
    }

    public WebElement getFilterBy() {
        return driver.findElement(By.className("detail-pages-filter__top-panel-holder"));
    }
}
