package dersCalismaDay05;

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

public class AutomationExercise04 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Logout' button
    //10. Verify that user is navigated to login page

    WebDriver driver;
    @Before
    public void setUp(){
        //1. Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test(){
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaKontrolu = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(anaSayfaKontrolu.isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement hesabaGirildiMiKontrolu = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(hesabaGirildiMiKontrolu.isDisplayed());
        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("yasir@selam.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement hesapGoruntusu =driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(hesapGoruntusu.isDisplayed());
        //9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();
        //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
       WebElement kontrol = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(kontrol.isDisplayed());


    }
}
