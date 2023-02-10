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

public class AutomationExercise08 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

    //1. Tarayıcıyı başlatın
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement homeSayfaTesti = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assert.assertTrue(homeSayfaTesti.isDisplayed());

    }

    @Test
    public void test02(){
        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //driver.manage().deleteCookieNamed("//div[@class='ns-1xi95-e-20']");
        //driver.findElement(By.xpath("//div[@class='ns-1xi95-e-20']")).click();

        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement allProductsTesti = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProductsTesti.isDisplayed());


    }

        @Test
        public void test03(){
            //6. Ürün listesi görünür
            //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın

            driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]")).click();
        }

        @Test
        public void test04(){
            //8. Kullanıcı ürün detay sayfasına yönlendirildi
        String expectedSayfa = "https://www.automationexercise.com/product_details/1";
        String actualSayfa = driver.getCurrentUrl();
        Assert.assertEquals(actualSayfa,expectedSayfa);
        }

        @Test
        public void test05(){
            //9. Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın.

            WebElement urunAdi = driver.findElement(By.xpath("//h2[text()='Blue Top']"));
            Assert.assertTrue(urunAdi.isDisplayed());

            WebElement category = driver.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
            Assert.assertTrue(category.isDisplayed());

            WebElement fiyat = driver.findElement(By.xpath("//span[text()='Rs. 500']"));
            Assert.assertTrue(fiyat.isDisplayed());

            WebElement adet = driver.findElement(By.xpath("//label[text()='Quantity:']"));
            Assert.assertTrue(adet.isDisplayed());

            WebElement stok = driver.findElement(By.xpath("//b[text()='Condition:']"));
            Assert.assertTrue(stok.isDisplayed());

            WebElement marka = driver.findElement(By.xpath("//b[text()='Brand:']"));
            Assert.assertTrue(stok.isDisplayed());
        }


    @AfterClass
    public static void tearDown(){
       // driver.close();
    }
}
