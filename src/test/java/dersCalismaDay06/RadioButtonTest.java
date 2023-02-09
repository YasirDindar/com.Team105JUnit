package dersCalismaDay06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButtonTest {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");

        //c. Create an account buton’una basin
        driver.findElement(By.xpath("(//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'])[1]")).click();

        //d. Radio button elementlerini locate edin ve size uygun olani secin

        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
    }


}
