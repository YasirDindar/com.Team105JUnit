package dersCalismaDay13;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        //Yeni bir class olusturun : amazonNutellaSearch
        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String zaman = ldt.format(dtf);
        String dosyaYeri = "target/ekranResimleri/tumEkranSS"+zaman+".jpeg";
       TakesScreenshot tss = (TakesScreenshot) driver;
       File tumSayfaSS = new File(dosyaYeri);
       File geciciResim = tss.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(geciciResim,tumSayfaSS);

        //3- Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        String aramaSonuclari = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String expectedKelime = "Nutella";
        Assert.assertTrue(aramaSonuclari.contains(expectedKelime));

        WebElement aramaSonuclari2 = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        LocalDateTime ldt2 = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String zaman2 = ldt2.format(dtf2);
        String dosyaYeri2 ="target/ekranResimleri/istenenElementSS"+zaman2+".jpeg";
        File istenenElementSS = new File(dosyaYeri2);
        File geciciResim2 = aramaSonuclari2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim2,istenenElementSS);
    }
}
