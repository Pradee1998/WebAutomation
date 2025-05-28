package Streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class tableSorting {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        System.out.println("browser Launched successfully");

        driver.findElement(By.xpath("(//th[@role='columnheader'])[1]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalvalue = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

        List<String> sortedList = originalvalue.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(sortedList.equals(originalvalue));
        List<String> price;
do {

    List<WebElement> elements2 = driver.findElements(By.xpath("//tr/td[1]"));
    price = elements2.stream().filter(s -> s.getText().contains("Cherry")).map(s -> getVeggiesPrice(s)).collect(Collectors.toList());

    price.forEach(s -> System.out.println(s));

    if (price.size() < 1) {
        driver.findElement(By.cssSelector("[aria-label='Next']")).click();
    }
}
while( price.size()<1);




    }

    private static String getVeggiesPrice(WebElement s) {
        String pricq = s.findElement(By.xpath("following-sibling::td[1]")).getText();
    return pricq;
    }
}
