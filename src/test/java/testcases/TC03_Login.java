package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;

import static testcases.TC02_Register.registeredUserData;

public class TC03_Login extends TestBase {

    P01_HomePage homePage;
    P03_LoginPage loginObject;

    //Tests
    @Test(priority = 1)
    public void VerifyLoginWithValidData() throws InterruptedException {

        loginObject = new P03_LoginPage(driver);
        loginObject.UserLogin(
                registeredUserData[2], // Email
                registeredUserData[4] // Password
        );
        Assert.assertTrue(loginObject.CheckLogOutButtonExistAfterLogin());

        Thread.sleep(5000);

        // Debugging to see if data is available
        // System.out.println("User data from TC01_Register: " + Arrays.toString(TC03_Login.registeredUserData));
    }

    @Test(priority = 2)
    public void VerifyLoginWithInValidEmail() throws InterruptedException {

        loginObject = new P03_LoginPage(driver);
        loginObject.UserLogin(
                registeredUserData[2], // Email
                registeredUserData[1] // Password
        );

        Assert.assertTrue(loginObject.IsLogInBtnExist());
    }

    @Test(priority = 3)
    public void VerifyLoginWithInValidPassword() throws InterruptedException {
        loginObject = new P03_LoginPage(driver);
        loginObject.UserLogin(
                registeredUserData[2], // Email
                registeredUserData[4] // Password
        );
        Assert.assertTrue(loginObject.IsLogInBtnExist());
    }

    //Verify open forget Password page
    @Test(priority = 4)
    public void VerifyOpenForgetPasswordPage() {

        loginObject =new P03_LoginPage(driver);
        loginObject.OpenForgetPasswordPage();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/forgotten");

    }
}