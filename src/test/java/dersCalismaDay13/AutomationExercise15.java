package dersCalismaDay13;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercise15 extends TestBase {
    @Test
    public void test01(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaGorunurlukTesti = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assert.assertTrue(anaSayfaGorunurlukTesti.isDisplayed());

        //4. Click 'Signup / Login' button
        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //5. Fill all details in Signup and create account
        //5. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(name)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement cinsiyet = driver.findElement(By.xpath("//input[@type='radio']"));
        actions.click(cinsiyet)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("India")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().country())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys("415")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().buildingNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //6. 'HESAP OLUŞTURULDU!'nu doğrulayın. ve 'Devam Et' düğmesini tıklayın
        WebElement hesapOlusturulduTesti = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(hesapOlusturulduTesti.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //7. Verify ' Logged in as username' at top
        //7. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        WebElement kullaniciGirisiTesti = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(kullaniciGirisiTesti.isDisplayed());

        //8. Add products to cart
        //8. Sepete ürün ekleyin
            driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();

        //9. Click 'Cart' button
        //9. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        //10. Verify that cart page is displayed
        //10. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepetSayfaGorunumTesti = driver.findElement(By.xpath("//a[text()='Proceed To Checkout']"));
        Assert.assertTrue(sepetSayfaGorunumTesti.isDisplayed());

        //11. Click Proceed To Checkout
        //11. Ödeme İşlemine Devam Et'i tıklayın
        sepetSayfaGorunumTesti.click();

        //12. Verify Address Details and Review Your Order
        //12. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        WebElement adresKontrolTesti = driver.findElement(By.xpath("(//div[@class='col-xs-12 col-sm-6'])[1]"));
        Assert.assertTrue(adresKontrolTesti.isDisplayed());

        //13. Enter description in comment text area and click 'Place Order'
        //13. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("adres");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //14. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        WebElement nameCard = driver.findElement(By.xpath("//input[@class='form-control']"));
        actions.click(nameCard)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.code().imei())
                .sendKeys(Keys.TAB)
                .sendKeys("123")
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .perform();

        //15. Click 'Pay and Confirm Order' button
        //15. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        //16. Verify success message 'Your order has been placed successfully!'
        //16. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        WebElement basariTesti = driver.findElement(By.xpath("//b[text()='Order Placed!']"));
        Assert.assertTrue(basariTesti.isDisplayed());

        //17. Click 'Delete Account' button
        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //18. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        WebElement silindiTesti = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(silindiTesti.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }
}
