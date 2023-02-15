package dersCalismaDay11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. Demo.txt dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='Demo.txt']")).click();
        ReusableMethods.bekle(3);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String downloadDosyaYolu = System.getProperty("user.home")+"\\Downloads\\Demo.txt";
        Assert.assertTrue(Files.exists(Paths.get(downloadDosyaYolu)));
    }
}
