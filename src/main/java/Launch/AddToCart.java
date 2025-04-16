package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        System.out.println("browser Launched successfully");
String[] items={"Cucumber","Beetroot"};
        List<String> litOfItems = Arrays.asList(items);
        List<WebElement> productElements = driver.findElements(By.className("product-name"));

        for (int i=0;i<productElements.size(); i++)
        {
            String names = productElements.get(i).getText();
            System.out.println(names);
            String fullName = productElements.get(i).getText();
            String[] splitName = fullName.split("-");
            String actualName = splitName[0].trim();
        if(litOfItems.contains(actualName))
        {
            System.out.println("Hii");

            driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

        }
        }
    }
}
