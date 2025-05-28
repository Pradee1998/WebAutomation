package projectObjects;

import ReusableComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects extends AbstractComponents {
WebDriver driver;
   public LandingPageObjects(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


       @FindBy(xpath="//input[@id='userEmail']")
       WebElement uerEmail;

       @FindBy(xpath = "//input[@id='userPassword']")
       WebElement userPassword;

       @FindBy(xpath = "//input[@id='login']")
       WebElement loginButton;


       public void loginPage(String email, String password)
       {
           uerEmail.sendKeys(email);
           userPassword.sendKeys(password);
           loginButton.click();
       }

       public void goTo()
       {
           driver.get("https://rahulshettyacademy.com/client");
       }

}
