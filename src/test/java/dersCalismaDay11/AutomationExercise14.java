package dersCalismaDay11;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class AutomationExercise14 extends TestBase {
    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaTesti = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        assertTrue(anaSayfaTesti.isDisplayed());

        //4. Add products to cart
        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        //5. Click 'Cart' button
        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //6. Verify that cart page is displayed
        //6. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepetSayfasi = driver.findElement(By.xpath("//a[text()='Proceed To Checkout']"));
        Assert.assertTrue(sepetSayfasi.isDisplayed());

        //7. Click Proceed To Checkout
        //7. Ödeme İşlemine Devam Et'i tıklayın
        sepetSayfasi.click();

        //8. Click 'Register / Login' button
        //8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();

        //9. Fill all details in Signup and create account
        //9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions = new Actions(driver);
        Faker faker =new Faker();
        actions.click(name)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        WebElement cinsiyet = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        actions.click(cinsiyet)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("13")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.demographic().educationalAttainment())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("India")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.country().capital())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.country().capital())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.code().imei())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.esports().game())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //10. 'HESAP OLUŞTURULDU!'nu doğrulayın! ve 'Devam Et' düğmesini tıklayın
        WebElement accountCreatedElementi = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        assertTrue(accountCreatedElementi.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        //11. Verify ' Logged in as username' at top
        //11. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        WebElement kullaniciGirisKontrolu = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(kullaniciGirisKontrolu.isDisplayed());

        //12.Click 'Cart' button
        //12.'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //13. Click 'Proceed To Checkout' button
        //13. 'Ödeme İşlemine Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();

        //14. Verify Address Details and Review Your Order
        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        WebElement adresAyrintilari = driver.findElement(By.xpath("//h3[text()='Your delivery address']"));
        Assert.assertTrue(adresAyrintilari.isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'
        //15. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("svlklsfvöl");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        WebElement cardName = driver.findElement(By.xpath("//input[@class='form-control']"));
        actions.click(cardName)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.finance().iban())
                .sendKeys(Keys.TAB)
                .sendKeys("132")
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("1965")
                .perform();

        //17. Click 'Pay and Confirm Order' button
        //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();

        //18. Verify success message 'Your order has been placed successfully!'
        //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        WebElement basariliTesti = driver.findElement(By.xpath("//b[text()='Order Placed!']"));
        assertTrue(basariliTesti.isDisplayed());

        //19. Click 'Delete Account' button
        //19. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //20. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        WebElement silindiTesti = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        assertTrue(silindiTesti.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

    }
}
