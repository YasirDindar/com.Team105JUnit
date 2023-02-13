package dersCalismaDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowsHandle01 extends TestBase {
   @Test
    public void test01(){
       //● Amazon anasayfa adresine gidin.
       driver.get("https://www.amazon.com");

       //● Sayfa’nin window handle degerini String bir degiskene atayin
       String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();

       //● Sayfa title’nin “Amazon” icerdigini test edin
       String expectedKelime = "Amazon";
       String actualTitle = driver.getTitle();
       Assert.assertTrue(actualTitle.contains(expectedKelime));

       //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.wisequarter.com");

       //● Sayfa title’nin “wisequarter” icerdigini test edin
       expectedKelime = "wisequarter";
       actualTitle = driver.getTitle();

       //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.get("https://www.walmart.com");

       //● Sayfa title’nin “Walmart” icerdigini test edin
       expectedKelime = "Walmart";
       actualTitle = driver.getTitle();
       Assert.assertTrue(actualTitle.contains(expectedKelime));

       //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

       driver.switchTo().window(ilkSayfaWindowHandleDegeri);
   }

}
