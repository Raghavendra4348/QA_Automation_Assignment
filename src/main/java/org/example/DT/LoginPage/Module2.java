package org.example.DT.LoginPage;

import io.opentelemetry.sdk.resources.ResourceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ResourceBundle;


public class Module2 {

    WebDriver driver;

    @FindBy(name = "username")
    WebElement user;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(id = "login")
    WebElement login;

    By SLogin = By.xpath("//h5[contains(text(),'Welcome to DeepThought')]");

    public Module2(WebDriver driver){
        this.driver = driver;
    }

    public void ValidCredentials() throws InterruptedException {

        ResourceBundle r = ResourceBundle.getBundle("config");
        String a = r.getString("email");
        String b = r.getString("password");

        user.clear();
        Thread.sleep(3000);
        pass.clear();
        Thread.sleep(3000);
        user.sendKeys(a);
        Thread.sleep(3000);
        pass.sendKeys(b);
        Thread.sleep(3000);
        login.click();

    }

    public WebElement Get_Login_Successful() throws InterruptedException {
        WebElement SLog = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(SLogin)));

        Thread.sleep(3000);
        return SLog;
    }
}
