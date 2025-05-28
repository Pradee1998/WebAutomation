package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Draganddrop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        System.out.println("browser Launched successfully");
        driver.findElements(By.id("iframes")).size();
        System.out.println(driver.findElements(By.id("iframes")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions act = new Actions(driver);
        act.dragAndDrop(source, destination).build().perform();
    }
}
