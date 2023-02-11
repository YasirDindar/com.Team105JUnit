package dersCalismaDay08;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class DropDown2 {
    //● Bir class oluşturun: C3_DropDownAmazon
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin

        WebElement dropDownElement = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(dropDownElement);

        List<WebElement>dropDownOptionListesi = select.getOptions();
        int actualDropDownOptionListesi = dropDownOptionListesi.size();
        int expectedDropDownOptionListesi = 28;

        Assert.assertEquals(expectedDropDownOptionListesi,actualDropDownOptionListesi);
    }


    @Test
    public void test02(){
        ////-Test 2

        //    //1. Kategori menusunden Books secenegini secin
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(dropDownElement);
        select.selectByVisibleText("Books");
        //    //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);
        //    //3. Bulunan sonuc sayisini yazdirin
        List<WebElement> sonucSayisi =  driver.findElements(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        for (WebElement each:sonucSayisi
             ) {
            System.out.println(each.getText());
        }
        //    //4. Sonucun Java kelimesini icerdigini test edin

        String actualKelime = driver.getTitle();
        String expectedKelime ="Java";
        Assert.assertTrue(actualKelime.contains(expectedKelime));
    }
}
