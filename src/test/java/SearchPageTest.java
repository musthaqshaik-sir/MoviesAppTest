import Pages.HomePage;
import Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\nxtwave\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);

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
    public void searching(){
        searchPage.clicksearchbut();
        searchPage.search1();
        searchPage.clickonsearchbut();
    }




}
