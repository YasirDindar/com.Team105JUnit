package day09_Actions;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C01_MouseActions extends TestBase {
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        String ilkSayfaWHD =driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement ciziliAlanElementi = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        Set<String>ikiSayfaninWHDegeriSeti =driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD :ikiSayfaninWHDegeriSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD = eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedTag = "Elemental Selenium";
        String actualTag =driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedTag,actualTag);
    }

}
