package dersCalismaDay11;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle extends TestBase {
    @Test
    public void test(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);

        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        String ilkSayfaWHDegeri = driver.getWindowHandle();

        //4.Diger window'a gecin
        Set<String>ikiSayfaninWHDegeriSeti = driver.getWindowHandles();
        String ikinciSayfaWHDegeri ="";
        for (String eachWHD: ikiSayfaninWHDegeriSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHDegeri = eachWHD;
            }
        }
        driver.switchTo().window(ikinciSayfaWHDegeri);

        //5."username" ve "password" kutularina deger yazdirin
        WebElement userNameElementi = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Faker faker =new Faker();
        actions.click(userNameElementi)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPopUpYazisi = "validation failed";
        String actualPopUPYazisi =driver.switchTo().alert().getText();
        Assert.assertEquals(expectedPopUpYazisi,actualPopUPYazisi);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWHDegeri);

        ReusableMethods.bekle(3);
        //10.Ilk sayfaya donuldugunu test edin
        String expectedIlkSayfaUrl = "http://webdriveruniversity.com/";
        String actualIlkSayfaUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedIlkSayfaUrl,actualIlkSayfaUrl);
    }
}
