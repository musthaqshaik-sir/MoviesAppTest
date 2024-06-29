package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopularPage {
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div/div")
    WebElement movies;

    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement movie(){
        return movies;
    }




}


