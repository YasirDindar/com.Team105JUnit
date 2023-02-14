package dersCalismaDay10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class GenelTekrarTamamlanmadi extends TestBase {
    @Test
    public void test01(){
        //amazon gidin
        driver.get("https://www.amazon.com");

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        dropDownMenu.click();
        System.out.println(dropDownMenu.getText());

        //3- dropdown menude 40 eleman olduğunu doğrulayın
        Select select = new Select(dropDownMenu);
        List<WebElement> dropDownSelectOptions = select.getOptions();
        int actualOptions = dropDownSelectOptions.size();
        int expectedOptions = 40;
        Assert.assertEquals(actualOptions,expectedOptions);

    }
    @Test
    public void test02(){
        driver.get("https://www.amazon.com");
        //Test02
        //1- dropdown menuden elektronik bölümü seçin
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);

        String aramaSonuclari = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(aramaSonuclari);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedKelime = "iphone";
        Assert.assertTrue(aramaSonuclari.contains(expectedKelime));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrunElementi = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        ikinciUrunElementi.click();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        //2-dropdown’dan bebek bölümüne secin
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4-sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
