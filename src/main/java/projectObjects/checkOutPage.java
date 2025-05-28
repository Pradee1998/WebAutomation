package projectObjects;

import ReusableComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutPage extends AbstractComponents {
WebDriver driver;
    public checkOutPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

@FindBy(css="[placeholder='Select Country']")
WebElement selectCountryDropdown;

@FindBy(xpath=("//a[@class='btnn action__submit ng-star-inserted']"))
WebElement submit;

@FindBy(xpath = ("(//button[contains(@class,'ta-item')])[1]"))
    WebElement countrySelect;


public void selectCountry(String countryName) throws InterruptedException {
    Actions ation= new Actions(driver);
    ation.sendKeys(selectCountryDropdown,countryName).build().perform();
    Thread.sleep(3000);
    countrySelect.click();


}

public void submitOrder()
{
    submit.click();
}



}
