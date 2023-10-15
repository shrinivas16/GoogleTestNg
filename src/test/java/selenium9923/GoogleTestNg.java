package selenium9923;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTestNg {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeSuite
    public void setup() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void testGoogleTitle() throws InterruptedException
    {
        driver.get("https://www.google.com");
        String pageTitle = driver.getTitle();
        softAssert.assertEquals(pageTitle, "Google", "Page title does not match Google");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void testGoogleSearch() throws InterruptedException
    {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium TestNG");
        searchBox.submit();
        String title = driver.getTitle();
        softAssert.assertTrue(title.contains("Selenium TestNG"), "Search results do not contain 'Selenium TestNG'");
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void testGoogleGmail() throws InterruptedException{
        driver.get("https://www.google.com");
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();
        String title = driver.getTitle();
        softAssert.assertEquals(title, "Gmail - Email from Google", "Page title does not match Gmail");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void testGoogleImagesAfterSearch() throws InterruptedException
    {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium TestNG");
        searchBox.submit();
        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        imagesLink.click();
        String title = driver.getTitle();
        softAssert.assertEquals(title, "Google Images", "Page title does not match Google Images");
        Thread.sleep(3000);
    }
    

//    @Test(priority = 5)
//    public void testGoogleNewsAfterSearch() {
//        driver.get("https://www.google.com");
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("Selenium TestNG");
//        searchBox.submit();
//
//        // Wait for the "More" dropdown to be clickable
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement moreDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-msb")));
//        moreDropdown.click();
//
//        WebElement newsLink = driver.findElement(By.linkText("News"));
//        newsLink.click();
//        String title = driver.getTitle();
//        softAssert.assertEquals(title, "Google News", "Page title does not match Google News");
//    }
    
    
    
//    @Test(priority = 5)
//    public void testOpenGoogleAppsAndGoogleStore() {
//        driver.get("https://www.google.com");
//
//        // Locate and click the Google Apps button
//        WebElement googleAppsButton = driver.findElement(By.id("gbwa"));
//        googleAppsButton.click();
//
////        // Wait for the Google Apps menu to appear
////        WebDriverWait wait = new WebDriverWait(driver, 10);
////         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gbwa")));
//
//        // Scroll down to the Google Store link
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        // Click the Google Store link
//        WebElement googleStoreLink = driver.findElement(By.linkText("Google Store"));
//        googleStoreLink.click();
//
//        // Wait for the Google Store page to load
//        //wait.until(ExpectedConditions.titleContains("Google Store"));
//
//        // Verify that the user is on the Google Store page
//        String title = driver.getTitle();
//        softAssert.assertTrue(title.contains("Google Store"), "Failed to navigate to Google Store.");
//    }
    @Test(priority = 6)
    public void testMultipleActions() {
        driver.get("https://www.google.com");

        
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium TestNG");
        searchBox.submit();

        
        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        imagesLink.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        
        WebElement googleStoreLink = driver.findElement(By.linkText("Google Store"));
        googleStoreLink.click();

        
        String title = driver.getTitle();
        softAssert.assertTrue(title.contains("Google Store"), "Failed to navigate to Google Store.");

    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
        softAssert.assertAll();
    }
}
