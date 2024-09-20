import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthenticationTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }
    @Test(priority = 1)
    public void positiveLoginTest(){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordFieled = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys("tomsmith");
        passwordFieled.sendKeys("SuperSecretPassword!");
        loginButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"));

    }
    @Test(priority = 2)
    public void negativeLoginTest(){
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("WrongPassword!");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("Your password is invalid!"));

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
