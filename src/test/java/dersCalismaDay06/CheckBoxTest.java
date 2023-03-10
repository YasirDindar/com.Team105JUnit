package dersCalismaDay06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckBoxTest {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement cb1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement cb2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın ve secili oldugunu test edin

        if (!cb1.isSelected()){
            cb1.click();
        }

        Assert.assertTrue(cb1.isDisplayed());

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın ve secili oldugunu test edin

        if (!cb2.isSelected()){
            cb2.click();
        }

        Assert.assertTrue(cb2.isDisplayed());
    }

}
