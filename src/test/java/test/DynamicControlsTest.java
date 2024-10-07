package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

public class DynamicControlsTest {
    @Test
    public void testDynamicControls() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Нажимаем на кнопку Remove
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();

        Thread.sleep(1000);
        WebElement messageElement = driver.findElement(By.id("message"));
        Assert.assertEquals("It's gone!", messageElement.getText());

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        Assert.assertFalse(checkbox.isDisplayed());

        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(inputField.isDisplayed());
        Assert.assertFalse(inputField.isEnabled());

        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();

        Thread.sleep(1000);
        Assert.assertEquals("It's enabled!", messageElement.getText());

        Assert.assertTrue(inputField.isEnabled());

        driver.quit();
    }
}