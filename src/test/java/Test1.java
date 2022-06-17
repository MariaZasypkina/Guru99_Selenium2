import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;


public class Test1 {

@Test
public void CheckXPathTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://galeapps.gale.com/apps/udemy/auth?SAMLRequest=fZDdToNAEIVfhex9WQpC0wmQUNtEVEy0jRJvyBZXi7I%2FMruh%2BvQFjEm98WYyJ5lzZuaLkYlWQ2bNQT7wT8vROOuhNJKZRsmEHIzRCJS%2BsZYzrdEdG7dWgo6K2hcuvigb7MR55B1OHt%2F1iJOvE5J7pS5udFlk%2BH0hFqW6D1X%2F9L7tK76xx%2BvLV7v%2FiAIbVrtNXl0FMyYbsQyK%2FWrh3634kIFoeS7RMGmGWM%2F3Z140m0e7%2BQLCEIKlG3j%2BM3GOopUI0ysJsZ0ExbBBkExwBFPDNituYbgKdKeMqlVL0nichmlBd%2Bb%2F384QeTdyIekvl77v3QnCxARR0TEmpmfx6Y%2F6Szk9AQ%3D%3D&RelayState=I0XpMKpXMAsz4m7XoQ5owWjSw_eEuxJCfubk63u5_TEI_H3-anim93MbB72NBe");
        driver.findElement(By.xpath("//input[contains(@value,'PUB')]")).click();
        driver.findElement(By.xpath("//input[contains(@type, 'text')]")).sendKeys("Anythink Libraries");
        driver.findElement(By.xpath("//button[contains(@class,'search-btn')]")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement result = driver.findElement(By.xpath("//div[@class='header-message']"));

        Assert.assertTrue(result.getText().toLowerCase().contains("we found"));


        driver.quit();
}
}
