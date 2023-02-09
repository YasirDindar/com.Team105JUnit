package dersCalismaDay06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YanlisEmailTesti {
    //1. Bir Class olusturalim YanlisEmailTesti
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test(){
        //2. http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        //3. Sign in butonuna basalim
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
        //email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("Yasir.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    }
}
