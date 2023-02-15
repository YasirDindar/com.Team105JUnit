package dersCalismaDay11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class FileUpload extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileElementi = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\MerhabaJava.rtf";
        chooseFileElementi.sendKeys(dosyaYolu);
        ReusableMethods.bekle(3);

        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@class='button']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedTesti = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        assertTrue(fileUploadedTesti.isDisplayed());
    }
}
