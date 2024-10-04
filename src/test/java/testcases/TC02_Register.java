package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import util.Utilities;

import java.util.Arrays;

import static util.Utilities.generateRandomRegisterData;

public class TC02_Register extends TestBase {
    P02_RegisterPage registerPageObject;
    public static String[] registeredUserData = generateRandomRegisterData(); // Store generated user data globally
    String SuccessRegisterMessage ="Congratulations! Your new account has been successfully created!";


    //Tests
    // VerifyRegisterWithValidRandomEmailAndPassword
    @Test(priority = 1)
    public void VerifyRegisterWithValidData() throws InterruptedException {

        registerPageObject = new P02_RegisterPage(driver);
        // Use the data for registration
        registerPageObject.userRegistration(
                registeredUserData[0], // First Name
                registeredUserData[1], // Last Name
                registeredUserData[2], // Email
                registeredUserData[3], // Telephone
                registeredUserData[4], // Password
                registeredUserData[5] // Confirm Password
        );
        Thread.sleep(5000);
        // Print text register success
        System.out.println(registerPageObject.GettextSuccessRegister());
        // Debugging to see if data is available
        System.out.println("User data from TC01_Register: " + Arrays.toString(TC02_Register.registeredUserData));
        Assert.assertEquals(registerPageObject.GettextSuccessRegister(),SuccessRegisterMessage);
        Assert.assertTrue(registerPageObject.CheckLogOutButtonExistAfterRegister());
    }


    //VerifyRegisterWithInValidRandomEmailAndInVlaidPassword
    @Test(priority = 2)
    public void VerifyRegisterWithInValidEmail() throws InterruptedException {
        registerPageObject = new P02_RegisterPage(driver);
        // Use the data for registration
        registerPageObject.userRegistration(
                registeredUserData[0], // First Name
                registeredUserData[1], // Last Name
                registeredUserData[1], // Email
                registeredUserData[3], // Telephone
                registeredUserData[4], // Password
                registeredUserData[5] // Confirm Password
        );
        Assert.assertTrue(registerPageObject.IsContinueBtnExist());

    }

    //VerifyRegisterWithInValidRandomEmailAndInVlaidPassword
    @Test(priority = 3)
    public void VerifyRegisterWithInvalidPassword() throws InterruptedException {

        registerPageObject = new P02_RegisterPage(driver);
        // Get random user data
        registeredUserData = generateRandomRegisterData();
        // Use the data for registration
        registerPageObject.userRegistration(
                registeredUserData[0], // First Name
                registeredUserData[1], // Last Name
                registeredUserData[2], // Email
                registeredUserData[3], // Telephone
                registeredUserData[4], // Password
                registeredUserData[3] // Confirm Password
        );
        Assert.assertTrue(registerPageObject.IsContinueBtnExist());

    }
}
