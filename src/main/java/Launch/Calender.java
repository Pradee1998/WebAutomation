package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calender {
    public static void main(String[] args) throws InterruptedException {
        String day="5";
        String Month="6";
        String Year="2027";
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        System.out.println("browser Launched successfully");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+Year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(Month)-1).click();
        driver.findElement(By.xpath("//button[contains(@class,'react-calendar__month-view__days__day')]/abbr[text()='"+day+"']")).click();

        List<WebElement> date = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i=0; i<date.size(); i++)
        {
Thread.sleep(2000);
            System.out.println(date.get(i).getAttribute("value"));
        }
    }
}
