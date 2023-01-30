package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_HandleDropdownMenu {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
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
    public void test01() throws InterruptedException {
           /*
        ilgili ayarlari yapip
        amazon anasayfaya gidin
        arama kutusu yanindaki drop down menuden book secin
        arama kutusuna java yazdirip aramayi yapin
        title'in java icerdigini test edin
         */

        driver.get("https://www.amazon.com");

        /*
        Drop down menuden istedigimiz option'i secebilmek icin
        oncelikle select class'indan bir obje olusturmaliyiz
        ancak select objesi olusturmak icin select class'inin constructor'i
        handle edecegimiz webelement'i istediginden
        1-select objesi olusturmadan once dropdown webelementini locate etmeliyiz

        */
        WebElement dropDownWebElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-select class'indan obje olusturmak

        Select select = new Select(dropDownWebElementi);

        //3-select objesinin kullanarak istedigimiz method veya methodlari calistirin
        //3 secenek ile de belirtebiliriz;

        //select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        String expectedKelime = "Java";
        String actualTitle =driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));

        //dropdown menuden Books seceneginin secildigini test edin
        /*
        locate ettigimiz elementi bulamazsa NoSuchElementException
        sayfa yenilendigi icin var olan elementi kullanamazsa StaleElementException verir
        bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir.
         */

        dropDownWebElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownWebElementi);
        select.selectByVisibleText("Books");


        String actualSecilenOption =select.getFirstSelectedOption().getText();
        String expectedSecilecekOption ="Books";

        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);

        /*
        DropDown menudeki secenek sayisinin 28 oldugunu test edin
         */
        List<WebElement>optionsWebElementListesi= select.getOptions();

        int actualOptionSayisi = optionsWebElementListesi.size();
        int expectedOptionSayisi = 28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        Thread.sleep(5000);
    }


}
