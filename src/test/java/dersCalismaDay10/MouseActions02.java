package dersCalismaDay10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class MouseActions02 extends TestBase {
    @Test
    public void test01(){
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement tasinacakElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement birakilacakAlanElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(tasinacakElement,birakilacakAlanElement).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedKelime ="Dropped!";
        String actualKelime = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedKelime,actualKelime);
    }
}
