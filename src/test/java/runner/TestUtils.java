package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtils {

    public void Driver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
    }
}
