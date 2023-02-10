package dersCalismaDay07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise07 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Test Cases' button
    //5. Verify user is navigated to test cases page successfully

    //1. Tarayıcıyı başlatın
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
    public void test01(){
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

    }

    @Test
    public void test02() {
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaGorunurlugu = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(anaSayfaGorunurlugu.isDisplayed());


    }

    @Test
    public void test03() throws InterruptedException {

        //4. 'Test Durumları' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();

        driver.manage().deleteCookieNamed("//span[@class='ns-qwh2z-e-21']");

    }

    @Test
    public void test04() throws InterruptedException {
        //5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın

        WebElement testCaseGorunurlukTesti = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(testCaseGorunurlukTesti.isDisplayed());

    }

}
