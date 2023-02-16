package dersCalismaDay12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables02 extends TestBase {
    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        WebElement basliklar = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("basliklar : \n"+basliklar.getText());

        System.out.println("*****************");

        // 3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBaslik = driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]"));
        System.out.println("ucuncu satir basligi : "+ucuncuSutunBaslik.getText());

        System.out.println("-------------------------");

        // 4. Tablodaki tum datalari yazdirin
        WebElement tumData = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println("tum data : "+ tumData.getText());

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> datalarListesi = driver.findElements(By.xpath("//div[@class='rt-td']"));
        int siraaNo =1;
        for (WebElement each:datalarListesi
             ) {
            if (!(each.getText().equals("") || each.getText().equals(" "))){
                System.out.println(siraaNo + ". - "+each.getText());
                siraaNo++;
            }
        }
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement>satirSayisi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("tabloda yer alan satir sayisi : "+ satirSayisi.size());

        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunSayisi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("tabloda yer alan sutun sayisi : "+sutunSayisi.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement>ucuncuKolon = driver.findElements(By.xpath("((//div[@class='rt-tr-group']))//div[1]/div[3]"));
        for (WebElement each:ucuncuKolon
        ) {
            if (!(each.getText().equals("") || each.getText().equals(" "))){
                System.out.println(each.getText());
            }
        }

        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        for (int i = 0; i <datalarListesi.size() ; i++) {
            if (datalarListesi.get(i).getText().equals("Kierra")){
                System.out.println("istenen kisinin maasi : "+datalarListesi.get(i+4).getText());
            }
        }
    }
}
