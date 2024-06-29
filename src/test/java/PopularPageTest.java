import Pages.HomePage;
import Pages.LoginPage;
import Pages.PopularPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopularPageTest {
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    PopularPage popularPage;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\nxtwave\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        popularPage = new PopularPage(driver);
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

    @Test
    public void movieslist(){
        Assert.assertTrue(popularPage.movie().isDisplayed(),"is not");

    }
}
