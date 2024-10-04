package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

import static util.Utilities.RandomCategoryGenerator;
import static util.Utilities.RandomCategoryGeneratorMainTabs;

public class P01_HomePage {
    WebDriver driver;
    // Static variable to toggle between USD and EURO
    private static boolean isUsdSelected = true;

    // create constructor
    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Variable And Locator
    final private By myAccountList = By.xpath("//span[@class='caret']");
    final private By registerPage = By.xpath("//a[text()='Register']");
    final private By loginPage = By.xpath("//a[text()='Login']");
    final private By CurrencyBtn = By.xpath(" //button[@class='btn btn-link dropdown-toggle']");
    final private By Dollar = By.xpath("//button[text()='$ US Dollar']");
    final private By Euro = By.xpath("//button[text()='€ Euro']");
    final private By DesktopBtn = By.xpath("//a[text()='Desktops']");
    final private By LaptopsNotebooksBtn = By.xpath("//a[text()='Laptops & Notebooks']");
    final private By ComponentsBtn = By.xpath("//a[text()='Components']");
    final private By AddToCartBtn = By.xpath("//div[@class= 'product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12'][2]//span[text()='Add to Cart']");
    final private By AddToWishListBtn = By.xpath("//div[@class= 'product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12'][1]//button[@data-original-title='Add to Wish List']");
    final private By AddToComparisonByn = By.xpath("//div[@class= 'product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12'][3]//button[@data-original-title='Compare this Product']");
    final private By GetSuccessTextOrder = By.xpath(" //div[text()=' Success: You have added ']");
    final private By OpenCartDropDown = By.xpath("//span [@id='cart-total']");
    final private By CheckOutBtn = By.xpath("//a[@title='Checkout']");

// keywords /action/ methods

    // 1- pen register Page
    public void OpenRegisterPage() {
        driver.findElement(myAccountList).click();
        driver.findElement(registerPage).click();
    }

    //2-   Get header URL Register page
    public String GetHeaderLoginTest() {
        return driver.getCurrentUrl();
    }

    //3-  Open Login Page
    public void OpnLoginPage() {
        driver.findElement(myAccountList).click();
        driver.findElement(loginPage).click();
    }

    //4-   Get header URL Login
    public String GetHeaderRegisterTest() {
        return driver.getCurrentUrl();
    }


    //5- Change currency automatically toggling between USD and EURO
    public void ChangeCurrency() throws InterruptedException {
        // Click on the currency button to open the dropdown
        driver.findElement(CurrencyBtn).click();
        Thread.sleep(1000); // Short delay for dropdown to appear
        // Toggle between USD and EURO based on the static variable
        if (isUsdSelected) {
            // Select EURO
            driver.findElement(Euro).click();
            System.out.println("Currency switched to EURO.");
        } else {
            // Select USD
            driver.findElement(Dollar).click();
            System.out.println("Currency switched to USD.");
        }
        // Toggle the static variable for next run
        isUsdSelected = !isUsdSelected;
        Thread.sleep(1000); // Wait for currency to change
    }




    // 6- Method to get the current currency from the UI
    public String GetCurrentCurrency() {
        return driver.findElement(CurrencyBtn).getText();
    }



// 4- Random hover Buttons

    public void HoverRandomMenusButtons() throws InterruptedException {
        // Generate a random category using your RandomCategoryGenerator
        // Correctly format the XPath
        String SelectorMenuXpath = "//a[text()='" + RandomCategoryGeneratorMainTabs() + "']";
        // Find the element using the correctly formatted XPath
        WebElement MenusLinksHover = driver.findElement(By.xpath(SelectorMenuXpath));
        // Perform hover and click action
        Actions ActionObj = new Actions(driver);
        Thread.sleep(200);
        ActionObj.moveToElement(MenusLinksHover).build().perform();
        Thread.sleep(200);
    }


    //5-  Random hover Buttons and subcategory
    public void HoverRandomMenusButtonsAndSubCategory() {
        // Generate a random category using your RandomCategoryGenerator
        // Correctly format the XPath
        String SelectorMenuXpath = "//a[text()='" + RandomCategoryGenerator() + "']";
        // Find the element using the correctly formatted XPath
        WebElement MenusLinksHover = driver.findElement(By.xpath(SelectorMenuXpath));
        // Perform hover and click action
        Actions ActionObj = new Actions(driver);
        ActionObj.moveToElement(MenusLinksHover).click().build().perform();

        // Assuming the structure is the same, we can use a generic subcategory XPath
        // Adjust the XPath below to match the actual structure of your subcategories
        List<WebElement> subCategories = driver.findElements(By.xpath("//a[ancestor::li[contains(@class,'open')]]"));

        // Check if subcategories are available
        if (subCategories.size() > 0) {
            // Select a random subcategory
            Random random = new Random();
            int randomSubIndex = random.nextInt(subCategories.size());
            WebElement RandomSubCategory = subCategories.get(randomSubIndex);

            System.out.println("Randomly selected subcategory: " + RandomSubCategory.getText());

            // Hover over and click the random subcategory
            ActionObj.moveToElement(RandomSubCategory).build().perform();
        } else {
            System.out.println("No subcategories found for the selected main category.");
        }
    }

    //6- Add item to cart
    public void AddProductToCart() {
        driver.findElement(AddToCartBtn).click();

    }

    ;


    //7- Add item to wishList
    public void AddProductToWishList() {
        driver.findElement(AddToWishListBtn).click();

    }

    ;

    //9- Add item to comparison list
    public void AddProductToComparisonList() {
        driver.findElement(AddToComparisonByn).click();

    }

    ;

    //9- GetTextSuccessOrder
    public String GetTextSuccessOrder() {
        return driver.findElement(GetSuccessTextOrder).getText();

    }

    ;


    //9- OpenCheckOutPage
    public void OpenCheckOutPage() {

        driver.findElement(CheckOutBtn).click();

    }

    ;

}


