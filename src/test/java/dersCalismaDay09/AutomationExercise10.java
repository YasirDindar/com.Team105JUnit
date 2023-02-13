package dersCalismaDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise10 extends TestBase {
    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaKontrolu = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assert.assertTrue(anaSayfaKontrolu.isDisplayed());

        //4. Scroll down to footer
        //4. Altbilgiye doğru aşağı kaydırın
       // anaSayfaKontrolu.sendKeys(Keys.PAGE_DOWN);

        //5. Verify text 'SUBSCRIPTION'
        //5. 'ABONELİK' metnini doğrulayın
        String expectedKelime ="SUBSCRIPTION";
        String actualKelime =driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
        Assert.assertEquals(expectedKelime,actualKelime);

        //6. Enter email address in input and click arrow button
        //6. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("yasir@selam.com");
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        //7. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        expectedKelime ="You have been successfully subscribed!";
        actualKelime= driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']")).getText();
        Assert.assertEquals(expectedKelime,actualKelime);

    }
}
