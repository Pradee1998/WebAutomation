package TestCases;

import ReusableComponents.AbstractComponents;
import TestComponents.Retry;
import TestComponents.baseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projectObjects.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitTest extends baseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData",groups = "smoke",retryAnalyzer = Retry.class)
    public void submitOrder(HashMap<String,String> input) throws InterruptedException {

        String countryName = "india";
        LandingPageObjects loginPage = new LandingPageObjects(driver);
        Thread.sleep(4000);
        loginPage.loginPage(input.get("userName"), input.get("password"));
        ProductCatlogues productPage = new ProductCatlogues(driver);
        productPage.addProductToCart(input.get("productName"));
        productPage.goToCartPage();
        CartPage carPage = new CartPage(driver);
        Boolean match = carPage.verifyCartProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        carPage.clickOnCheckOut();
        checkOutPage checkoutPage = new checkOutPage(driver);
        checkoutPage.selectCountry(countryName);
        checkoutPage.submitOrder();
        confirmationPage confirmationPage = new confirmationPage(driver);
        String actualMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(actualMessage.equalsIgnoreCase("Thankyou for the order."));


    }

    @Test(dependsOnMethods ={"submitOrder"} )
    public void orderHistoryTest() throws InterruptedException {
        LandingPageObjects loginPage = new LandingPageObjects(driver);
        Thread.sleep(4000);
        loginPage.loginPage("pradeephg1998@gmail.com", "Pradee@123");
        AbstractComponents components = new AbstractComponents(driver);
        components.gotoOrderPage();
        OrderPage oPage = new OrderPage(driver);
        Boolean isOrderMatch = oPage.verifyOrderDisplay(productName);
        Assert.assertTrue(isOrderMatch);
    }


@DataProvider
    public Object[][] getData() throws IOException {
//        HashMap<String,String> map1= new HashMap<>();
//        map1.put("userName","pradeephg1998@gmail.com");
//        map1.put("password","Pradee@123");
//        map1.put("productName","ZARA COAT 3");
//
//
//        HashMap<String,String> map2= new HashMap<>();
//        map2.put("userName","pradeephg2025@gmail.com");
//        map2.put("password","Pradee@123");
//        map2.put("productName","ADIDAS ORIGINAL");
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/TestData/purchaseOrder.json");
    return new Object[][] {{data.get(0)},{data.get(1)}};
      //  return new Object[][] {{map1},{map2}};
    }
}
