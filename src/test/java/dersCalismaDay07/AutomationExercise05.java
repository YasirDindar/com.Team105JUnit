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

public class AutomationExercise05 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and already registered email address
    //7. Click 'Signup' button
    //8. Verify error 'Email Address already exist!' is visible


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
    //6. Adı ve e-posta adresini girin
    //7. 'Kaydol' düğmesini tıklayın
    //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür

    @Test
    public void test(){
        driver.get("http://automationexercise.com");
        WebElement anaSayfaGorunurlukTesti = driver.findElement(By.xpath("//div[@class='brands-name']"));
        Assert.assertTrue(anaSayfaGorunurlukTesti.isDisplayed());
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        WebElement yeniKullaniciKaydiGorunurlukTesti = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(yeniKullaniciKaydiGorunurlukTesti.isDisplayed());
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("yasir");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("yasir@selam.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement postaKontrolu = driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(postaKontrolu.isDisplayed());

    }
}
