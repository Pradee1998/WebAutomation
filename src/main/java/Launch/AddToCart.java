package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        System.out.println("Browser launched successfully");

        String[] items = {"Cucumber", "Beetroot"};
        List<String> listOfItems = Arrays.asList(items);

        List<WebElement> productElements = driver.findElements(By.className("product-name"));

        addItem(productElements, listOfItems, driver);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        String text = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
        System.out.println(text);

    }

    // ✅ Fixed method signature and parameter types
    public static void addItem(List<WebElement> productElements, List<String> listOfItems, WebDriver driver) {
        for (int i = 0; i < productElements.size(); i++) {
            String fullName = productElements.get(i).getText();  // e.g., "Cucumber - 1 Kg"
            String[] splitName = fullName.split("-");
            String actualName = splitName[0].trim();

            System.out.println("Product Found: " + actualName);

            if (listOfItems.contains(actualName)) {
                System.out.println("Adding to cart: " + actualName);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }
        }
    }
}
