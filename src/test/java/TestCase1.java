import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class TestCase1 {
// verify item in MOBILE list can be sorted by name
// Steps:
// 6. verify all products are sorted by name
// Expected results:
// 1. Text 'THIS IS DEMO SITE' shown in home page
// 2. Title 'MOBILE' is shown on mobile list page
// 3. all 3 products sorted by name

    @Test
    public void testNumberOne(){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://live.techpanda.org/"); //1

        Assert.assertEquals(driver.getTitle(), "Home page"); //2

        WebElement mobileButton = driver.findElement(
                By.cssSelector("#nav > ol > li.level0.nav-1.first > a"));


        mobileButton.click(); //3

        Assert.assertEquals(driver.getTitle(), "Mobile"); //4

        WebElement sortMenu =
                driver.findElement(
                        By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
        sortMenu.click();
        driver.manage().
                timeouts().
                implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")).click();

WebElement product1 = driver.findElement(By.cssSelector("li.item:nth-child(1) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)"));
WebElement product2 = driver.findElement(By.cssSelector("li.item:nth-child(2) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)"));
WebElement probuct3 = driver.findElement(By.cssSelector("li.item:nth-child(3) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)"));

String [] arr = {product1.getText(), product2.getText(), probuct3.getText()};






    }
}
