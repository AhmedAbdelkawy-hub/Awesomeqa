package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {


    static WebDriver driver;

    SoftAssert softAssert = new SoftAssert();

    @Parameters("browsername")
    @BeforeTest
    public void setupWebDriver(String browsername) {

        setDriver(getNewInstance(browsername));
        driver=getDriver();

        //Step4: maximize window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://awesomeqa.com/ui/");
    }

   @AfterTest
    public void teardown() {
        driver.quit();

    }




}
