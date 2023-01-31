package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        //linke tikladigimizda yeni sayfa acilacagindan click yapmadan once
        //ilk sayfanin whd alip kaydedelim
        String ilkSayfaWHD = driver.getWindowHandle();

        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //click yapinca yeni tab acilir. Ancak driver eski tab'da kalir.
        //yeni tab'a driveri gecirmek icin yeni tab'in
        //whd ihtiyacimiz var
        Set<String>ikiSayfaninWHDegerleriSeti = driver.getWindowHandles();

        String ikinciSayfaWHDegeri ="";

        for (String eachWHD:ikiSayfaninWHDegerleriSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHDegeri=eachWHD;
            }

        }
        //frech loop bittiginde ikinci sayfanin whd'ini elde etmis olacagiz
        //bu degeri kullanarak driveri 2.sayfaya gecirebiliriz

        driver.switchTo().window(ikinciSayfaWHDegeri);

        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        String expectedIkinciSayfaYazi = "Elemental Selenium";
        String actualIkinciSayfaYazi = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedIkinciSayfaYazi,actualIkinciSayfaYazi);
        Thread.sleep(3000);

        // ilk sayfaya geri donup sayfadaki yazinin
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

        driver.switchTo().window(ilkSayfaWHD);

        String expectedIlkSayfaYazi = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualIlkSayfaYazi = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedIlkSayfaYazi,actualIlkSayfaYazi);
    }
}
