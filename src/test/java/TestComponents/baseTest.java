package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import projectObjects.LandingPageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class baseTest {
   public WebDriver driver;
   public ExtentReports extent;

    public WebDriver initialiseDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//GlobalData.properties");
        prop.load(fip);
        String browserName =System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
        // prop.getProperty("browserName");cl

        if (browserName.contains("chrome")) {

            ChromeOptions options=new ChromeOptions();
            //This helps to run in headless mode
            if(browserName.contains("headless"))
            {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);
            //This helps to run in full screen
            driver.manage().window().setSize(new Dimension(1440,900));

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        // Cast driver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as file
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define destination path
        File destination = new File(System.getProperty("user.dir") + "//reports//" + fileName + ".png");
        FileUtils.copyFile(source,destination);
        return System.getProperty("user.dir") + "//reports//" + fileName + ".png";

    }


    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        // Read JSON to string
        String jsonContent = FileUtils.readFileToString(
                new File(filePath),
                StandardCharsets.UTF_8
        );

        // Convert JSON string to List of HashMaps
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                }
        );
        return data;

    }

    @BeforeMethod(alwaysRun=true)
    public void launchApplication() throws IOException {
        driver=initialiseDriver();
        LandingPageObjects loginPage= new LandingPageObjects(driver);
        loginPage.goTo();
    }

    @AfterMethod(alwaysRun=true)
    public  void tearDown()
    {
        driver.close();
    }


}
