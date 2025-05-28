package ReusableComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

WebDriver driver;
    public AbstractComponents(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[routerlink*='cart']")
    WebElement cartButton;


    @FindBy(css="[routerlink*='myorders']")
    WebElement orderButton;

    public void waitElementToAppear(By findby)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
    }

    public void waitForTheElementDisappear(WebElement element)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void goToCartPage()
    {
        cartButton.click();
    }

    public void gotoOrderPage()
    {
        orderButton.click();
    }
}
