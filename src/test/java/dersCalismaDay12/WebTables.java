package dersCalismaDay12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {
    @Test
    public void test(){
        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement>satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        Assert.assertEquals(10,satirSayisi.size());

        System.out.println("*********************");
        //5.Tum satirlari yazdirin
        for (WebElement eachRow:satirSayisi
             ) {
            System.out.println(eachRow.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement>sutunSayisi = driver.findElements(By.xpath("//tbody//tr[1]//td"));
        Assert.assertEquals(13,sutunSayisi.size());

        //7. 5.sutunu yazdirin
        List<WebElement>besinciSutun = driver.findElements(By.xpath("//tbody//tr//td[5]"));
        System.out.println("////////////////////////");
        for (WebElement eachRow:besinciSutun
        ) {
            System.out.println(eachRow.getText());
        }
        System.out.println("++++++++++++++++++++++");
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        WebElement istenenSatirSutun = getElement(3,5);
        System.out.println(istenenSatirSutun.getText());
    }

    private WebElement getElement(int satir, int sutun) {
        String yeniPacth ="//tbody//tr["+satir+"]//td["+sutun+"]";
        WebElement istenenElement = driver.findElement(By.xpath(yeniPacth));
        return istenenElement;
    }
}
