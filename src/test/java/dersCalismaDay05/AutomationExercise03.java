package dersCalismaDay05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise03 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter incorrect email address and password
    //7. Click 'login' button
    //8. Verify error 'Your email or password is incorrect!' is visible

    //1. Tarayıcıyı başlatın

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
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
        WebElement anaSayfaTesti = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        if (anaSayfaTesti.isDisplayed()){
            System.out.println("test PASSED");
        }else {
            System.out.println("test FAILED");
        }
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement hesapGorunurluguTesti = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        if (hesapGorunurluguTesti.isDisplayed()){
            System.out.println("hesap gorunurluk testi PASSED");
        }else {
            System.out.println("hesap gorunurluk testi FAILED");
        }
        //6. Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ksmkx@sf.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("135");
        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        WebElement gecersizGirisTesti = driver.findElement(By.xpath("//p[@style='color: red;']"));
        if (gecersizGirisTesti.isDisplayed()){
            System.out.println("gecersiz giris testi PASSED");
        }else {
            System.out.println("gecersiz giris testi FAILED");
        }

    }

}
