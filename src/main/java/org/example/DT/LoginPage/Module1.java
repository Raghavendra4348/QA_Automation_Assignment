package org.example.DT.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ResourceBundle;

public class Module1 {
    WebDriver driver;

    @FindBy(name = "username")
    WebElement user;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(id = "login")
    WebElement login;

    By Wrong_Login = By.xpath("//p[contains(text(),'Invalid login credentials')]");

    public Module1(WebDriver driver){
        this.driver = driver;
    }

    public void InvalidCredentials() throws InterruptedException {

        ResourceBundle r = ResourceBundle.getBundle("config");
        String email = "raghavnani77@gmail.com";
        String password = "nani12345";

        user.sendKeys(email);
        Thread.sleep(3000);
        pass.sendKeys(password);
        Thread.sleep(3000);
        login.click();
        Thread.sleep(5000);
    }

    public WebElement Get_Wrong_Login() throws InterruptedException {
        WebElement WrongLog = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(Wrong_Login)));

        Thread.sleep(3000);
        return WrongLog;
    }
}
