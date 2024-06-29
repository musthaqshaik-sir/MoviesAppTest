package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/h1")
    WebElement heading;
    @FindBy(className = "home-movie-play-button")
    WebElement playbut;
    @FindBy(className = "contact-us-paragraph")
    WebElement contact;
    @FindBy(id = "usernameInput")
    WebElement userinput;
    @FindBy(id = "passwordInput")
    WebElement passwordinput;
    @FindBy(className = "login-button")
    WebElement loginbutton;
    @FindBy(className = "website-logo")
    WebElement weblogo;



    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public void playbutton(){
        playbut.click();
    }

    public String contacttext(){
        return contact.getText();
    }

    public void username(String userid){
        userinput.sendKeys(userid);
    }
    public void password(String pin){
        passwordinput.sendKeys(pin);
    }
    public void clickloginbutton() {
        loginbutton.click();

    }
    public WebElement websitelogo(){
        return weblogo;
    }


    public void loginaplication(String userid, String pin){
        username(userid);
        password(pin);
        loginbutton.click();
    }

}
