package Streams;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SeleniumFourNewWindow {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        System.out.println("browser Launched successfully");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> window = windows.iterator();
        String parentWindow = window.next();
        String childWindow = window.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String text = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/']")).get(1).getText();

driver.switchTo().window(parentWindow);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(text);
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));

        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());

    }
}
