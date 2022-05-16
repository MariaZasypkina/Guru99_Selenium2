import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.stream.ImageInputStream;
import java.util.concurrent.TimeUnit;


public class TestCase1 {


    @Test
    public void testNumberOne(){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://live.techpanda.org/"); //1

        Assert.assertEquals(driver.getTitle(), "Home page"); //2

        WebElement header = driver.findElement(By.cssSelector(".page-title > h2:nth-child(1)"));

        Assert.assertEquals(header.getText().toUpperCase().trim(), "THIS IS DEMO SITE FOR ".toUpperCase().trim()); // 1. Text 'THIS IS DEMO SITE' shown in home page

        WebElement mobileButton = driver.findElement(
                By.cssSelector("#nav > ol > li.level0.nav-1.first > a"));


        mobileButton.click(); //3

        Assert.assertEquals(driver.getTitle(), "Mobile"); //4
                                                                    // Title 'MOBILE' is shown on mobile list page

        WebElement sortMenu =
                driver.findElement(
                        By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
        sortMenu.click();
        driver.manage().
                timeouts().
                implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath(
                "/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")).click(); // sort by name

        // verify item in MOBILE list can be sorted by name

        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");


//        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[3]")).click(); // sort by price

WebElement product1 = driver.findElement(By.cssSelector("li.item:nth-child(1) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)"));
WebElement product2 = driver.findElement(By.cssSelector("li.item:nth-child(2) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)"));
WebElement probuct3 = driver.findElement(By.cssSelector("li.item:nth-child(3) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)"));

String first = product1.getText().toUpperCase();
String second = product2.getText().toUpperCase();
String third = probuct3.getText().toUpperCase();

Assert.assertTrue((first.charAt(0) < second.charAt(0)) && (first.charAt(0) < third.charAt(0))); //6. verify all products are sorted by name
    }
}
