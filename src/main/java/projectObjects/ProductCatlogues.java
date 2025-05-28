package projectObjects;

import ReusableComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatlogues extends AbstractComponents {

    WebDriver driver;
    public ProductCatlogues(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
            WebElement spinner;

By product=By.cssSelector(".mb-3");
By adToCart =By.cssSelector(".card-body button:last-of-type");
By toastMessage=By.cssSelector("div[id='toast-container']");


public List<WebElement> listOfProducts()
{
    waitElementToAppear(product);
    return products;
}

public WebElement getProductName(String productName)
{
    WebElement prod = listOfProducts().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    return prod;

}

public void addProductToCart(String productName)
{
    WebElement prod=getProductName(productName);
    prod.findElement( adToCart).click();
    waitElementToAppear(toastMessage);
    waitForTheElementDisappear(spinner);


}


}
