package Launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HttpsCertification {
    public static void main(String[] args) {
        ChromeOptions ch=   new ChromeOptions();
        ch.setAcceptInsecureCerts(true);
        WebDriver driver= new ChromeDriver(ch);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://expired.badssl.com/");
        System.out.println("browser Launched successfully");
    }
}
