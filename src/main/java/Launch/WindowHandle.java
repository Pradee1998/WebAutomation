package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

public class WindowHandle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        System.out.println("browser Launched successfully");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".blinkingText")).click();

        String parentWindow = driver.getWindowHandle();
        Set<String> listOfWindows = driver.getWindowHandles();
        for (String window:listOfWindows)
        {
            if(!Objects.equals(window, parentWindow))
            {
                Thread.sleep(3000);
                driver.switchTo().window(window);
                Thread.sleep(3000);
                String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
                String emailIdt=text.split("at")[1].trim().split(" ")[0];
                driver.switchTo().window(parentWindow);
                driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailIdt);


            }
        }
    }
}
