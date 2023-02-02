package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {
    @Test
    public void test01() {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. Facebookd.png dosyasını indirelim
        WebElement fileDosyasiIndirmeTesti = driver.findElement(By.xpath("//a[text()='Facebookd.png']"));
        fileDosyasiIndirmeTesti.click();
        ReusableMethods.bekle(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //test icin oncelikle dosyanin indirildiginde dosyaYolu ne olacak bunu olusturmaliyiz
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\Facebookd.png";
        /*
        bir dosyanin bilgisayarimizda var oldugunu yani exist test etmek icin
        javadaki Files class'indan yardim alacagiz
         */
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02() {
        //masaustunde MerhabaJava.rtf  dosyasi oldugunu test edin.
        String dosyaYolu = System.getProperty("user.home")+ "\\Desktop\\MerhabaJava.rtf";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}