package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class FileUploadTest {
    @Test
    public void testFileUpload() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        //  путь к файлу
        String filePath = Paths.get("/to/file.txt").toAbsolutePath().toString();
        WebElement uploadElement = driver.findElement(By.id("file-upload"));
        uploadElement.sendKeys(filePath);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedText = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals("file.txt", uploadedText.getText());

        driver.quit();
    }
}