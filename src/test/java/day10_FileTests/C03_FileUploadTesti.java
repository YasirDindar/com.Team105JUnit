package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.

        /*
        bu gorevi yapabilmek icin chooseFile butonuna basildiginda
        acilan bilgisayarimizdaki file dosyalarini click yapabilmemiz gerekir
        ancak selenium bilgisayarimizdaki dosyalari click yapamaz

        bunun yerine soyle bir cozum uretilmistir

        1-chooseFile butonunu locate edin
        2- upload edilecek dosyanin dosya yolunu olusturun
        3-choose.File butonuna sendKeys ile dosya yolunu yollayin
         */
        WebElement chooseFileButonu = driver.findElement(By.xpath("//*[@id='file-upload']"));

        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\MerhabaJava.rtf";

        chooseFileButonu.sendKeys(dosyaYolu);

        ReusableMethods.bekle(8);

        //4.Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@class='button']")).click();

        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());
    }
}
