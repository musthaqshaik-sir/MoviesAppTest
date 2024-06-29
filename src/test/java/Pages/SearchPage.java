package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    @FindBy(className = "search-empty-button")
    WebElement clickbut;
    @FindBy(id = "search")
            WebElement search;
    @FindBy(className = "search-button")
    WebElement searchbut;

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void search1(){
       search.sendKeys("no time to die");
    }
    public void clicksearchbut(){
        clickbut.click();
    }
    public void clickonsearchbut(){
        searchbut.click();
    }

}
