package dersCalismaDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class WindowsHandle03 extends TestBase {
    @Test
    public void test(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilkSayfaWHD =driver.getWindowHandle();

        // elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        Set<String>ikiSayfaninWHDegerSeti =driver.getWindowHandles();
        String ikinciSayfaWHD ="";
        for (String eachWHD :ikiSayfaninWHDegerSeti
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD = eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        String expextedKelime ="Elemental Selenium";
        String actualKelime = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expextedKelime,actualKelime);

        // ilk sayfaya geri donup sayfadaki yazinin
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
        driver.switchTo().window(ilkSayfaWHD);
        expextedKelime="An iFrame containing the TinyMCE WYSIWYG Editor";
        actualKelime=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expextedKelime,actualKelime);
    }

}
