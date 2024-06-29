package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    @FindBy(className = "login-website-logo")
    WebElement loginwebsitelogo;
    @FindBy(className = "sign-in-heading")
    WebElement signinheading;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/form/div[1]/label")
    WebElement usernamelable;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/form/div[2]/label")
    WebElement passwordlable;
    @FindBy(className = "login-button")
    WebElement loginbutton;
    @FindBy(id = "usernameInput")
    WebElement userinput;
    @FindBy(id = "passwordInput")
    WebElement passwordinput;
    @FindBy(how = How.CLASS_NAME, using = "error-message")
    WebElement errormessagetext;


    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement findinglogo(){
        return loginwebsitelogo;
    }
    public String signinheadingtext(){
        return signinheading.getText();
    }
    public String usernametex(){
        return usernamelable.getText();
    }
    public String passwordtext(){
        return passwordlable.getText();
    }

    public void clickloginbutton() {
        loginbutton.click();

    }
    public void username(String userid){
        userinput.sendKeys(userid);
    }
    public void password(String pin){
        passwordinput.sendKeys(pin);
    }

    public void loginaplication(String userid, String pin){
        username(userid);
        password(pin);
        loginbutton.click();
    }

    public String geterrormessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errormessagetext.getText();
    }
}
