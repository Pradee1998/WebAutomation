package TestngThings;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Loan3 {
@Parameters({"Username"})
    @Test (groups = {"smoke"})
    public  static void carLoan(String username)
    {
        System.out.println(username);
        System.out.println("car loan need to be paid ");
    }


@Test(groups = {"smoke"},dataProvider = "getData")
public static void multipleData(String uerName, String password)
{
    System.out.println(uerName);
    System.out.println(password);
}

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data= new Object[3][2];

        data[0][0]="firstUsername";
        data[0][1]="firstPassword";

        data[1][0]="secondUsername";
        data[1][1]="secondPassword";

        data[2][0]="thirdUsername";
        data[2][1]="thirdPassword";
        return data;
    }
}
