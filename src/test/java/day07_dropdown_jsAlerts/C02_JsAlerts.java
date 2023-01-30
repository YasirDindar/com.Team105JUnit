package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {
    /*
    gerekli ayarlamalari yapip
    https://the-internet.herokuapp.com/javascript_alerts adresine gidip
    3 test methpd'u olusturup her methodda bir jsAlert'e basin.
    ilgili methodlari kullanin.
     */

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

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1.alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //alert deki yazinin "I am a JS Alert" oldugunu test edelim

        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expectedAlertYazisi = "I am a JS Alert";

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //ok'a basalim
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2.alert'e tiklayalim
        //cancel'a basip cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        driver.switchTo().alert().dismiss();

        String actualSonucYazisi = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedSonucYazisi = "You clicked: Cancel";

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void test03(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3. alert'e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //cikan prompt ekranina "Yasir" yazdiralim ve OK tusuna basarak alert'i kapatalim


        driver.switchTo().alert().sendKeys("Yasir");
        driver.switchTo().alert().accept();

        //cikan sonuc yazisinin "Yasir" İCERDİGİNİ TEST EDELİM
        String actualSonucYazisi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedKelime = "Yasir";
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }
}
