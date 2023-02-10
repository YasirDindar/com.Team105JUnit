package dersCalismaDay07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise09 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test01(){
        driver.get("http://automationexercise.com");

        WebElement homeSayfaTesti = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assert.assertTrue(homeSayfaTesti.isDisplayed());


    }

    @Test
    public void test02(){
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        driver.manage().deleteCookieNamed("//div[@class='ns-6fcc8-e-6 close-button']");

        WebElement allTesti = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allTesti.isDisplayed());
    }

    @Test
    public void test03(){
     //   driver.manage().deleteCookieNamed("//body[@style='top: 0px;']");
     //   driver.findElement(By.xpath("//body[@style='top: 0px;']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Men Tshirt");
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }

    @Test
    public void test04(){

        WebElement searhedTest = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searhedTest.isDisplayed());

        WebElement urunTesti = driver.findElement(By.xpath("(//p[text()='Men Tshirt'])[1]"));
        Assert.assertTrue(urunTesti.isDisplayed());

    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
