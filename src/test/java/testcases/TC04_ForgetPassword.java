package testcases;

import org.testng.annotations.Test;
import pages.P04_ForgetPasswordPage;

import static testcases.TC02_Register.registeredUserData;

public class TC04_ForgetPassword extends TestBase{

    P04_ForgetPasswordPage ForgetPasswordObject;
    String EmailSentSuccessMessage="An email with a confirmation link has been sent your email address.";


    //Tests
    @Test
    public void VerifyForgetPasswordFunction() throws InterruptedException {
        ForgetPasswordObject= new P04_ForgetPasswordPage(driver);
        ForgetPasswordObject.RequestNewPassword(registeredUserData[2]);
       softAssert.assertEquals(ForgetPasswordObject.GetForgetPasswordEmailSentMessage(),EmailSentSuccessMessage);
    }
}
