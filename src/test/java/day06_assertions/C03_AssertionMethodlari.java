package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionMethodlari {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        //1- amazon'da gidip, amazon'a gittigimizi test edin
        driver.get("https://www.amazon.com");
        String expectedKelime = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));

    }

    @Test
    public void test2(){
        //2.methodda amazon'da nutella aratip sonuclarin nutella icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella", Keys.ENTER);
        String expectedKelime = "nutella";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String sonucYazisiStr=sonucYaziElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains(expectedKelime));

    }
    @Test
    public void test3(){
        //3.methodda nutella arama sayisinin 50 den fazla oldugunu test edin.
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr=sonucYaziElementi.getText();
        String[] sonucYazisiArr= sonucYazisiStr.split(" ");
        String sonucAdediStr=sonucYazisiArr[2]; // "74"
        int actualSonucAdediInt= Integer.parseInt(sonucAdediStr);

        int expectedAramaSonucusayisi= 50;

        Assert.assertTrue(actualSonucAdediInt>expectedAramaSonucusayisi);

    }

}
