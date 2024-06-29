import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\nxtwave\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
    @Test(priority = 1)
    public void testloginpage(){
        Assert.assertTrue(loginPage.findinglogo().isDisplayed(), "Page logo is not displayed");
        String actualltitle = loginPage.signinheadingtext();
        Assert.assertEquals(actualltitle, "Login");
        actualltitle = loginPage.usernametex();
        Assert.assertEquals(actualltitle, "USERNAME","Title text does not match");
        actualltitle = loginPage.passwordtext();
        Assert.assertEquals(actualltitle, "PASSWORD","Title text does not match");

        loginPage.clickloginbutton();
    }

    @Test(priority = 2)
    public void testempyinputs(){
        loginPage.clickloginbutton();
        String actualerrormessage = loginPage.geterrormessage();
        Assert.assertEquals(actualerrormessage, "*Username or password is invalid","Error text with empty input fields does not match");
    }
@Test(priority = 3)
    public void testemtyusername() {
    loginPage.loginaplication("", "rahul@2021");
    String actualerrormessage = loginPage.geterrormessage();
    Assert.assertEquals(actualerrormessage, "*Username or password is invalid", "Error text with empty input fields does not match");
}

@Test(priority = 4)
    public  void testemtypassword(){
        loginPage.loginaplication( "rahul", "");
        String actualerrormessage = loginPage.geterrormessage();
        Assert.assertEquals(actualerrormessage, "*Username or password is invalid", "Error text with empty input fields does not match");
}
@Test(priority = 5)
    public void testinvalidinputs(){
        loginPage.loginaplication("dfsad", "fds");
    String actualerrormessage = loginPage.geterrormessage();
    Assert.assertEquals(actualerrormessage, "*invalid username", "Error text with empty input fields does not match");
}

@Test(priority = 6)
    public void testvalidinputs(){
        loginPage.loginaplication("rahul", "rahul@2021");
        loginPage.clickloginbutton();
}




}


