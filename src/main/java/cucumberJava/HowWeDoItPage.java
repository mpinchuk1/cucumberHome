package cucumberJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HowWeDoItPage {

    private final WebDriver driver;

    public HowWeDoItPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("title")).findElement(By.tagName("h1"));
    }
}
