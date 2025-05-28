package Streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumfourLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        System.out.println("browser Launched successfully");

        WebElement element = driver.findElement(By.cssSelector("[name='name']"));

       String name= driver.findElement(with(By.tagName("label")).above(element)).getText();
        System.out.println(name);

        WebElement element1 = driver.findElement(By.cssSelector("[for='dateofBirth']"));

        driver.findElement(with(By.tagName("input")).below(element1)).click();
        WebElement leftelement = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

        driver.findElement(with(By.tagName("input")).toLeftOf(leftelement)).click();
//input[@id='inlineRadio1']


        WebElement rightelement = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));

        String text=driver.findElement(with(By.tagName("label")).toRightOf(rightelement)).getText();

        System.out.println(text);
    }
}
