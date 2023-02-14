package dersCalismaDay10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class MouseActions03 extends TestBase {
    @Test
    public void test(){
        //Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        WebElement accountListsElementi = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListsElementi).perform();
        ReusableMethods.bekle(3);

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement actualKelime = driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(actualKelime.isDisplayed());
    }
}
