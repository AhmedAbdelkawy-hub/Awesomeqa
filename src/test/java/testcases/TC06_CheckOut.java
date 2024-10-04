package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P06_CheckOutPage;

import static util.Utilities.*;

public class TC06_CheckOut extends  TestBase {

    P06_CheckOutPage CheckOutObject;
    String SuccessOrderMessage = "Your order has been successfully processed!";

    @Test(priority = 1)
    public void VerifyCreateSuccessOder() throws InterruptedException {

        CheckOutObject =new P06_CheckOutPage(driver);
        CheckOutObject.FillBillingDetails(getFirstName(),getLastName(),getCompany()
                ,getAddress(),getCity(),getPostCode()
        );
        CheckOutObject.DeliveryDetails();
        CheckOutObject.DeliveryMethod(generateRandomText());
       CheckOutObject.PaymentMethod();
        CheckOutObject.ConfirmOrder();
        System.out.println(CheckOutObject.GetSuccessOrderMessage());
        Assert.assertEquals(CheckOutObject.GetSuccessOrderMessage(),SuccessOrderMessage);
    }
}
