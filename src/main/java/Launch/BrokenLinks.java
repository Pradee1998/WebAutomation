package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("browser Launched successfully");
        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        for(WebElement link:links)
        {
       String  lin= link.getAttribute("href");

        URL url = new URL(lin);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int code = conn.getResponseCode();
        if(code>400)
        {
            System.out.println(link.getText() +"and status code is"+ code);
        }

    }}
}
