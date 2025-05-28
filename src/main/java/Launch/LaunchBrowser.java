package Launch;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("browser Launched successfully");
       /* Thread.sleep(3000);
        driver.findElement(By.id("inputUsername")).sendKeys("pradeephg");
        driver.findElement(By.name("inputPassword")).sendKeys("pradee@123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println( driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("pradeep");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("pradee123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("pradeephg");
        String password = password(driver);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String ActualText = driver.findElement(By.tagName("p")).getText();
        System.out.println(ActualText);
        Assert.assertEquals(ActualText,"You are successfully logged in.");*/
        //driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        // driver.findElement(By.xpath())

        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
        System.out.println(checkbox.isSelected());
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
        System.out.println(checkbox.isSelected());



    }

    public static String password(WebDriver driver)

    {
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
       String passwordTest= driver.findElement(By.cssSelector("form p")).getText();
        String[] splitedString = passwordTest.split("'");
       String password= splitedString[1].split("'")[0];
       return password;
    }
}
