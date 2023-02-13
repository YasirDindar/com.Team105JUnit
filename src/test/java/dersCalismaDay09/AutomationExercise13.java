package dersCalismaDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise13 extends TestBase {

    @Test
    public void test() {
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaKontrolu = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assert.assertTrue(anaSayfaKontrolu.isDisplayed());

        //4. Click 'View Product' for any product on home page
        //4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[2]")).click();

        //5. Verify product detail is opened
        //5. Ürün detayının açıldığını doğrulayın
        String expectedSatfaDogrulama = "Men Tshirt";
        String actualSayfaDogrulama = driver.findElement(By.xpath("//h2[text()='Men Tshirt']")).getText();
        Assert.assertTrue(actualSayfaDogrulama.contains(expectedSatfaDogrulama));

        //6. Increase quantity to 4
        //6. Miktarı 4'e yükseltin
        WebElement quantityElementi = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantityElementi.click();
        quantityElementi.clear();
        quantityElementi.sendKeys("4");

        //7. Click 'Add to cart' button
        //7. 'Sepete ekle' düğmesini tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();

        //8. Click 'View Cart' button
        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        //9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
        String expectedUrunAdedi ="4";
        String actualUrunAdedi =driver.findElement(By.xpath("//button[@class='disabled']")).getText();
        Assert.assertTrue(actualUrunAdedi.contains(expectedUrunAdedi));
    }
}
