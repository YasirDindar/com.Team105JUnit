package dersCalismaDay08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {
    //● Bir class oluşturun: DropDown
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
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownIndex = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select selectIndex = new Select(dropdownIndex);
        selectIndex.selectByIndex(1);

    }

    @Test
    public void test02(){

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement dropdownValue = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select selectValue = new Select(dropdownValue);
        selectValue.selectByValue("1");

    }

    @Test
    public void test03(){

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve
        //yazdırın
        WebElement dropdownVisibleText = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropdownVisibleText);
        select.selectByVisibleText("Option 1");

    }

    @Test
    public void test04(){
        //4.Tüm dropdown değerleri(value) yazdırın

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //degilse False yazdırın.

        WebElement dropdownVisibleText = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropdownVisibleText);
        select.selectByVisibleText("Option 1");


        List<WebElement>dropDownListesi = select.getOptions();

        int actualDropdownSayisi = dropDownListesi.size();
        int expectedDropDownSayisi = 4;

        Assert.assertEquals(expectedDropDownSayisi,actualDropdownSayisi);


    }






}
