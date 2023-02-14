package dersCalismaDay10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class ActionsClass01 extends TestBase {
    @Test
    public void test(){
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirstElementi = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirstElementi).perform();

        ReusableMethods.bekle(2);
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

        //4- Popup mesajini yazdirin
        String popUpMesage =driver.switchTo().alert().getText();
        System.out.println(popUpMesage);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElementi = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(clickAndHoldElementi).perform();
        ReusableMethods.bekle(2);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldElementi.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClikMeElementi = driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleClikMeElementi);
        ReusableMethods.bekle(2);
    }
}
