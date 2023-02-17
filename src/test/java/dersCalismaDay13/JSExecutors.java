package dersCalismaDay13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JSExecutors extends TestBase {
    @Test
    public void test01(){
        //Ornek : wisequarter anasayfasina gidin
        driver.get("https://www.wisequarter.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        // alt kisimda bulunan “Go To Career Page butonuna kadar asagi inin ve bu butona click yapin
        WebElement goToCareerPageElementi = driver.findElement(By.xpath("//i[@class='fas fa-paper-plane']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",goToCareerPageElementi);

    }

}
