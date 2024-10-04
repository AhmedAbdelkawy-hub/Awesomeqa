package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P05_AccountPage;

import static testcases.TC02_Register.registeredUserData;

public class TC01_Home extends TestBase {
    P03_LoginPage loginObject;
    P01_HomePage homePageObject;
    P05_AccountPage AccountPageObject;
    String LoginURL = "https://awesomeqa.com/ui/index.php?route=account/login";
    String RegisterURL = "https://awesomeqa.com/ui/index.php?route=account/register";

    @Test(priority = 1)
    public void ValidateLoginPage() throws InterruptedException {
        homePageObject=new P01_HomePage(driver);
        homePageObject.OpnLoginPage();
// SoftAssert
        softAssert.assertEquals(homePageObject.GetHeaderLoginTest(),LoginURL);
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void ValidateRegisterPage(){
        homePageObject=new P01_HomePage(driver);
        homePageObject.OpenRegisterPage();
        // SoftAssert
        softAssert.assertEquals(homePageObject.GetHeaderRegisterTest(),RegisterURL);
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void VerifyLoggedUserChangeCurrency() throws InterruptedException {
        homePageObject = new P01_HomePage(driver);
        // Capture the currency before changing
        String beforeChangeCurrency = homePageObject.GetCurrentCurrency();
        // Change the currency
        homePageObject.ChangeCurrency();
        // Capture the currency after changing
        String afterChangeCurrency = homePageObject.GetCurrentCurrency();
        // Assert that the currency has changed
        softAssert.assertNotEquals(afterChangeCurrency, beforeChangeCurrency,
                "Currency should have changed but it didn't.");
        // Assert the currency is either USD or EURO (based on toggle)
        softAssert.assertEquals(afterChangeCurrency,homePageObject.GetCurrentCurrency(),"Currency is USD or EURO ");
        softAssert.assertAll();
        System.out.println(homePageObject.GetCurrentCurrency());
    }

    @Test(priority = 3)
    public void VerifyHoverMenusMainLinks() throws InterruptedException {
        loginObject = new P03_LoginPage(driver);
        loginObject.UserLogin(
                registeredUserData[2], // Email
                registeredUserData[4] // Password
        );

        homePageObject = new P01_HomePage(driver);
        homePageObject.HoverRandomMenusButtons();
    }


      @Test(priority = 4)
    public void VerifyHoverMenusLinksAndSubCategory() throws InterruptedException {

          loginObject = new P03_LoginPage(driver);
          loginObject.UserLogin(
                  registeredUserData[2], // Email
                  registeredUserData[4] // Password
          );
        homePageObject = new P01_HomePage(driver);
        homePageObject.HoverRandomMenusButtonsAndSubCategory();
      }


    @Test(priority = 5)
    public void VerifyAddingItemToCart() throws InterruptedException {

        loginObject = new P03_LoginPage(driver);
        loginObject.UserLogin(
                registeredUserData[2], // Email
                registeredUserData[4] // Password
        );

        AccountPageObject = new P05_AccountPage(driver);
        AccountPageObject.OpenHomePage();

        homePageObject = new P01_HomePage(driver);
        homePageObject.AddProductToCart();
        System.out.println(homePageObject.GetTextSuccessOrder());
        Thread.sleep(500);
        Assert.assertEquals(homePageObject.GetTextSuccessOrder(),"Success: You have added iPhone to your shopping cart!\n" +
                "×");
    }



    @Test(priority = 6)
    public void VerifyAddingItemToWishList() throws InterruptedException {

        loginObject = new P03_LoginPage(driver);
        loginObject.UserLogin(
                registeredUserData[2], // Email
                registeredUserData[4] // Password
        );

        AccountPageObject = new P05_AccountPage(driver);
        AccountPageObject.OpenHomePage();

        homePageObject = new P01_HomePage(driver);
        homePageObject.AddProductToWishList();
        System.out.println(homePageObject.GetTextSuccessOrder());
        Assert.assertEquals(homePageObject.GetTextSuccessOrder(),"Success: You have added MacBook to your wish list!\n" +
                "×");

    }

    @Test(priority = 7)
    public void VerifyAddingItemToComparisonList() throws InterruptedException {

        loginObject = new P03_LoginPage(driver);
        loginObject.UserLogin(
                registeredUserData[2], // Email
                registeredUserData[4] // Password
        );

        AccountPageObject = new P05_AccountPage(driver);
        AccountPageObject.OpenHomePage();


        homePageObject = new P01_HomePage(driver);
        homePageObject.AddProductToComparisonList();
        System.out.println(homePageObject.GetTextSuccessOrder());
        Assert.assertEquals(homePageObject.GetTextSuccessOrder(),"Success: You have added Apple Cinema 30\" to your product comparison!\n" +
                "×");

    }


    @Test(priority = 8)
    public void VerifyOpenCheckOutPage() throws InterruptedException {

        homePageObject = new P01_HomePage(driver);
        homePageObject.OpenCheckOutPage();
    }

}


