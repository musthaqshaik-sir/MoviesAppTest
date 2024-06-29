import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;



    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\nxtwave\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.loginaplication("rahul", "rahul@2021");
        homePage.clickloginbutton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
    @Test(priority = 1)
    public void testheading() {
        String actual = homePage.getHeadingText();
        Assert.assertEquals(actual, "Trending Now");
    }

    @Test(priority = 2)
    public void testplaybutton(){
       homePage.playbutton();
    }

    @Test(priority = 3)
    public void contacttextt(){
        String actual = homePage.contacttext();
        Assert.assertEquals(actual, "Contact Us", "Contact Us not displayed");
    }
    @Test(priority = 4)
    public void websitelogo() {
        Assert.assertTrue(homePage.websitelogo().isDisplayed(), "not displayed");
    }




}
