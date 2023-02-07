package day13_writeExcel_Screenshot;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TakeSSTumSayfa extends TestBase {
    @Test
    public void test01(){
        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //anasayfaya gittiginizi test edin
        String expectedUrl = "wisequarter";
        String actualYrl =driver.getCurrentUrl();
        //tum sayfa screenshot alin
        ReusableMethods.tumSayfaScreenshotCek(driver);

    }
}
