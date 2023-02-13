package dersCalismaDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class WindowsHandle02 extends TestBase {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedKelime = "Opening a new window";
        String actualKelime = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedKelime,actualKelime);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedKelime,actualKelime);

        String ilkSayfaWHD =driver.getWindowHandle();
        ReusableMethods.bekle(3);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> ikiSayfaninWHDegerSeti =driver.getWindowHandles();
        String ikinciSayfaWHD ="";
        for (String eachWHD:ikiSayfaninWHDegerSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD =eachWHD;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        String expectedNewTitle="New Window";
        String actualNewTitle =driver.getTitle();
        Assert.assertEquals(expectedNewTitle,actualNewTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedNewKelime = "New Window";
        String actualNewKelime =driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedNewKelime,actualNewKelime);
        ReusableMethods.bekle(3);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        String expectedIlkSayfaTitle ="The Internet";
        String actualIlkSayfaTitle = driver.getTitle();
        Assert.assertEquals(expectedIlkSayfaTitle,actualIlkSayfaTitle);

    }

}
