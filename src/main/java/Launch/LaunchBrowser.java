package Launch;

import com.sun.tools.javac.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.udemy.com");
    }
}
