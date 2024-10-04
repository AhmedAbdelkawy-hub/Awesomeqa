package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P05_AccountPage;

import static util.Utilities.getRandomSearchValue;

public class TC05_Account extends  TestBase{

    public static String RandomSearchData = getRandomSearchValue();
    P05_AccountPage AccountObject;

    @Test
    public void VerifySearchForProducts() throws InterruptedException {
        AccountObject = new P05_AccountPage(driver);
        AccountObject.UserSearch(RandomSearchData);
        Assert.assertTrue(AccountObject.GetSearchText());
    }
}
