package dersCalismaDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class AutomationExercise12 extends TestBase {
    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaKontrolu = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        Assert.assertTrue(anaSayfaKontrolu.isDisplayed());

        //4. Click 'Products' button
        //4. 'Ürünler' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5. Hover over first product and click 'Add to cart'
        //5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("//span[text()='Close']")).click();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();

        //6. Click 'Continue Shopping' button
        //6. 'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@class='btn btn-success close-modal btn-block'])[1]")).click();

        //7. Hover over second product and click 'Add to cart'
        //7. İkinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();

        //8. Click 'View Cart' button
        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();


        //9. Verify both products are added to Cart
        //9. Her iki ürünün de Sepete eklendiğini doğrulayın
        String expectedIlkUrun = "Blue Top";
        String actualIlkUrun = driver.findElement(By.xpath("//a[text()='Blue Top']")).getText();
        Assert.assertTrue(actualIlkUrun.contains(expectedIlkUrun));

        String expectedIkinciUrun = "Men Tshirt";
        String actualIkinciUrun = driver.findElement(By.xpath("//a[text()='Men Tshirt']")).getText();
        Assert.assertTrue(actualIkinciUrun.contains(expectedIkinciUrun));


        //10. Verify their prices, quantity and total price
        //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın
        String expectedIlkUrunFiyati ="Rs. 500";
        String actualIlkUrunFiyati =driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]")).getText();
        Assert.assertTrue(actualIlkUrunFiyati.contains(expectedIlkUrunFiyati));

        String expectedIlkUrunQuantity ="1";
        String actualIlkUrunQuantity =driver.findElement(By.xpath("(//button[text()='1'])[1]")).getText();
        Assert.assertTrue(actualIlkUrunQuantity.contains(expectedIlkUrunQuantity));

        String expectedIlkUrunTotal ="Rs. 500";
        String actualIlkUrunTotal =driver.findElement(By.xpath("(//p[text()='Rs. 500'])[2]")).getText();
        Assert.assertTrue(actualIlkUrunFiyati.contains(expectedIlkUrunTotal));

        String expectedIkinciUrunFiyati ="Rs. 400";
        String actualIkinciUrunFiyati =driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]")).getText();
        Assert.assertTrue(actualIkinciUrunFiyati.contains(expectedIkinciUrunFiyati));

        String expectedIkinciUrunQuantity ="1";
        String actualIkinciUrunQuantity =driver.findElement(By.xpath("(//button[text()='1'])[2]")).getText();
        Assert.assertTrue(actualIkinciUrunQuantity.contains(expectedIkinciUrunQuantity));

        String expectedIkinciUrunTotal ="Rs. 400";
        String actualIkinciUrunTotal =driver.findElement(By.xpath("(//p[text()='Rs. 400'])[2]")).getText();
        Assert.assertTrue(actualIkinciUrunTotal.contains(expectedIkinciUrunTotal));


    }
}
