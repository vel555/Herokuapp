package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.junit.Assert;
import org.junit.Test;

public class ContextMenuTest {
    @Test
    public void testContextMenu() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(box).perform();

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("You selected a context menu", alertText);

        alert.accept();

        driver.quit();
    }
}