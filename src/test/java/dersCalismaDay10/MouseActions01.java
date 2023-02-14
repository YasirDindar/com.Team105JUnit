package dersCalismaDay10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class MouseActions01 extends TestBase {
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElementi = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertTrue(actualAlertYazisi.contains(expectedAlertYazisi));

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        String ilkSayfaWhDegeri = driver.getWindowHandle();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String>ikiSayfaninWHDegerSeti = driver.getWindowHandles();
        String ikinciSayfaninWHDegeri ="";
        for (String eachWHDegeri:ikiSayfaninWHDegerSeti
             ) {
            if (!eachWHDegeri.equals(ilkSayfaWhDegeri)){
                ikinciSayfaninWHDegeri=eachWHDegeri;
            }
        }
        driver.switchTo().window(ikinciSayfaninWHDegeri);

        String expectedKelime ="Elemental Selenium";
        String actualKelime =driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
    }
}
