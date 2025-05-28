package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Standalone {

    public static void main(String[] args) throws InterruptedException {
String name="ZARA COAT 3";
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("pradeephg1998@gmail.com");
        driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Pradee@123");
        driver.findElement(By.xpath("//input[@id='login']")).click();

        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = listOfProducts.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);

        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='toast-container']")));

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
       Boolean match= cartProduct.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(name));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".totalRow button")).click();
        Actions ation= new Actions(driver);
        ation.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
//wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.cssSelector(".ta-results"))));
Thread.sleep(3000);
driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[1]")).click();
driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
    }
}
