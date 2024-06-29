package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage {
    @FindBy(className = "avatar-button")
    WebElement accountbut;

    @FindBy(className = "logout-button")
            WebElement logout;


    WebDriver driver;
    WebDriverWait wait;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickonaccount(){
        accountbut.click();
    }

}
