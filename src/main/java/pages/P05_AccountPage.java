package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_AccountPage {
    // 1- initiate WebDriver
    // 2- constructor ->
    // 3- locators -> private
    // 4- action methods -> public

    WebDriver driver;

    public P05_AccountPage(WebDriver driver) {
        this.driver = driver;
    }


    // 3- locators -> private
    final private By SearchText = By.xpath("//input[@placeholder='Search']");
    final private By SearchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");
    final private By HomeBtn= By.xpath("//li/a[@href='https://awesomeqa.com/ui/index.php?route=common/home']");
    final private By SearchTextResults =By.xpath("//h2[text()='Products meeting the search criteria']");


    // 4- action methods -> public
    public void UserSearch(String SearchData) throws InterruptedException {
        driver.findElement(SearchText).sendKeys(SearchData);
        driver.findElement(SearchBtn).click();
        Thread.sleep(300);
    }

    // 5-method for success search fr product
      public boolean GetSearchText(){
        return driver.findElement(SearchTextResults).isDisplayed();
      }


    //6- OpenHomePage
    public void OpenHomePage(){
        driver.findElement(HomeBtn).click();

    };

}
