package org.example.DT.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class EdgeTest {

    WebDriver driver;
    Module1 obj;

    String Wrong_Credentials;

    String Login_Successful;

    @BeforeClass
    @Parameters({"browser", "Url"})
    public void openBrowser(String browser, String Url) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("Runs on Chrome Driver",".\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            obj = new Module1(driver);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("Runs on Edge Driver",".\\MicrosoftWebdriver.exe");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            obj = new Module1(driver);
        }
        driver.get(Url);
    }

    @Test
    public void DTLoginTest() throws InterruptedException {
        driver.manage().window().maximize();

        PageFactory.initElements(driver, Module1.class);
        Module1 WrongCredentials = PageFactory.initElements(driver, Module1.class);
        WrongCredentials.InvalidCredentials();
        Wrong_Credentials =WrongCredentials.Get_Wrong_Login().getText();


        PageFactory.initElements(driver,Module1.class);
        Module2 ValidLogin = PageFactory.initElements(driver,Module2.class);
        ValidLogin.ValidCredentials();
        Login_Successful = ValidLogin.Get_Login_Successful().getText();


    }

    @Test
    public void ValidateData(){
        Assert.assertEquals(Wrong_Credentials,"Invalid login credentials");

        Assert.assertEquals(Login_Successful,"Welcome to DeepThought");

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }


}
