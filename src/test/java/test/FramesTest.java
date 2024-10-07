package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

public class FramesTest {
    @Test
    public void testFrames() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");

        driver.switchTo().frame("frame-top");

        WebElement paragraph = driver.findElement(By.id("content"));
        Assert.assertEquals("Your content goes here.", paragraph.getText());

        driver.switchTo().defaultContent();

        driver.quit();
    }
}
