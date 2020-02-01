package sa_app;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class ZestTest {
    WebDriver driver = new ChromeDriver();
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_GREEN = "\u001B[32m";

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
    }

    @Test(priority = 1, enabled = true, groups = "one", description = "User login")
    public void priceSearch() throws InterruptedException {
        //To open Amazon URL
        try {
            driver.geturl("https://www.amazon.in");
            System.out.println(ANSI_GREEN + "App Launched Successfully");

        } catch (Exception e) {
            System.out.println(ANSI_RED + "url not found");
        }
        // to maximize browser window
        try {
            driver.manage().window().setSize(new Dimension(1410, 1600));
            System.out.println(ANSI_GREEN + "Maximising browser window");
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Not able to maximize browser window");
        }

        //X-path search option
        String searchBoxAmazon = "//*[@id='twotabsearchtextbox']";
        driver.findElement(By.xpath(searchBoxAmazon)).sendKeys("iPhone XR (64GB) - Yellow");

        String searchiconAmazon = "//*[@id='nav-search-submit-text']";
        driver.findElement(By.xpath(searchiconAmazon)).click();

        driver.wait(3000);

        String mobileLinkAmazon = "//*[contains(text(),'Apple iPhone XR (64GB) - Yellow')]";
        driver.findElement(By.xpath(mobileLinkAmazon)).click();

        String mobilePriceAmazon = "//*[@id='priceblock_ourprice_row']//*[@id='priceblock_ourprice']";
        String amazonPrice  = driver.findElement(By.xpath(mobilePriceAmazon)).getText();

        try {
            driver.geturl("https://www.flipkart.com/");
            System.out.println(ANSI_GREEN + "App Launched Successfully");

        } catch (Exception e) {
            System.out.println(ANSI_RED + "url not found");
        }

        String searchBoxFlipkart = "//*[@title='Search for products, brands and more']";
        driver.findElement(By.xpath(searchBoxFlipkart)).sendKeys("iPhone XR (64GB) - Yellow");

        String searchiconFlipkart = "//*[@class='vh79eN' and @type='submit']";
        driver.findElement(By.xpath(searchiconFlipkart)).click();

        driver.wait(3000);

        String mobilePriceFlipkart = "//*[@class='_1vC4OE _2rQ-NK']";
        String flipkartPrice  = driver.findElement(By.xpath(mobilePrice)).getText();

        if((Integer.parseInt(flipkartPrice)) > (Integer.parseInt(amazonPrice))){
            System.out.println(ANSI_GREEN + "Flipkart's Price is higher");
        }
        else{
            System.out.println(ANSI_RED + "Flipkart's Price is lower");
        }
    }
}
