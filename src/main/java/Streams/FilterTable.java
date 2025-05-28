package Streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTable {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        System.out.println("browser Launched successfully");

        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
        List<WebElement> listOfRice = driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> filterdList = listOfRice.stream().filter(listOfRie -> listOfRie.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(listOfRice,filterdList);
    }


}
