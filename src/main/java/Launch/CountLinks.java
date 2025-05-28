package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CountLinks {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        System.out.println("browser Launched successfully");
        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement links = driver.findElement(By.xpath("//div[@id='gf-BIG']"));

        System.out.println(links.findElements(By.tagName("a")).size());
        WebElement footerLiksBlock1 = links.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        footerLiksBlock1.findElements(By.tagName("a"));
        System.out.println(footerLiksBlock1.findElements(By.tagName("a")).size());

        for (int i = 1; i < footerLiksBlock1.findElements(By.tagName("a")).size(); i++) {
            String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footerLiksBlock1.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
        }
        Thread.sleep(4000);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> window = windows.iterator();
        while (window.hasNext()) {
            driver.switchTo().window(window.next());
            System.out.println(driver.getTitle());
        }
    }


}
