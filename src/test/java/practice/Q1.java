package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
///*..........Exercise1............
//    BeforeClass ile driver'i olusturun ve class icinde static yapin
//    Maximize edin ve 10 sn bekletin
//    http://www.google.com adresine gidin
//    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
//    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
//    AfterClass ile kapatin
//     */
    static WebDriver driver;
    @BeforeClass
public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("http://www.google.com");
        //arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("The Lord of the Rings", Keys.ENTER);
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
    }

    @Test
    public void test02(){
        //    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//div[@class='M2vV3 vOY7J']")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("Brave Heart",Keys.ENTER);
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
    }

    @Test
    public void test03(){
        //    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//div[@class='M2vV3 vOY7J']")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramaKutusu.sendKeys("Harry Potter",Keys.ENTER);
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
    }
}
