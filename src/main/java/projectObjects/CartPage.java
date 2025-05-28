package projectObjects;

import ReusableComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
WebDriver driver;
    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(css=".cartSection h3")
List<WebElement> cartProduct;

@FindBy(css=".totalRow button")
WebElement checkOut;
    public Boolean verifyCartProductDisplay(String productName)
    {

        Boolean match= cartProduct.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
         return match;
    }

    public  void clickOnCheckOut()
    {
        checkOut.click();
    }
}
