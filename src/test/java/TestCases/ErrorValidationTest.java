package TestCases;

import TestComponents.baseTest;
import org.testng.annotations.Test;
import projectObjects.LandingPageObjects;

public class ErrorValidationTest extends baseTest {

    @Test(groups = {"smoke"})
    public void errorValidation() throws InterruptedException {
        LandingPageObjects loginPage = new LandingPageObjects(driver);
        Thread.sleep(4000);
        loginPage.loginPage("pradeephg1998@gmail.com", "Pradee@123");
    }


}
