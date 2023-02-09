package dersCalismaDay06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BestBuyAssertion {

    // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //asagidaki testleri yapin
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin


        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test02(){
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitleKelime = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitleKelime));

    }
    @Test
    public void test03(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoTesti = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoTesti.isDisplayed());
    }

    @Test
    public void test04(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisLinkTest = driver.findElement(By.xpath("(//button[@lang='fr'])[1]"));
        Assert.assertTrue(francaisLinkTest.isDisplayed());
    }
}
