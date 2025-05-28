package Launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DeleteCookies {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("browser Launched successfully");
        TakeScreenshot driver1 = (TakeScreenshot) driver;


    }
}
