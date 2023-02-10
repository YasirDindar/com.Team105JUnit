package dersCalismaDay07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise06 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully

    //1. Tarayıcıyı başlatın
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin

        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın

        WebElement anaSayafaKontrolu = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(anaSayafaKontrolu.isDisplayed());
        //4. 'Bize Ulaşın' düğmesine tıklayın

        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();
        //5. "İLETİŞİME GEÇİN" ifadesinin görünür olduğunu doğrulayın

        WebElement iletisimeGecinElementKontrolu = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(iletisimeGecinElementKontrolu.isDisplayed());
        //6. Adı, e-postayı, konuyu ve mesajı girin

        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Yasir");
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("Yasir@selam.com");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("konu");
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("mesaj");
        //7. Dosya yükleyin


        WebElement dosyaYukleme = driver.findElement(By.xpath("//input[@type='file']"));
        dosyaYukleme.sendKeys("C:\\Users\\yasir\\Desktop\\ders\\WebsiteTesting.pdf");
        Thread.sleep(3000);

        //8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //9. Tamam düğmesine tıklayın

        Alert alert = driver.switchTo().alert();
        alert.accept();

        //10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
        WebElement basarilimiSorgulamasi = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(basarilimiSorgulamasi.isDisplayed());

        //11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın
        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
        WebElement anaSayafaKontrolu2 = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(anaSayafaKontrolu2.isDisplayed());

    }




}
