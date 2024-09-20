import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }

    @Test
    public void checkboxesTest(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        Assert.assertFalse(checkbox1.isSelected(),"Checkbox 1 should not be selected.");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be selected.");

        if (checkbox1.isSelected()){
            checkbox1.click();
        }
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 should NOT be selected after clicking.");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be selected after clicking.");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
