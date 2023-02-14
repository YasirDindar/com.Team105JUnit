package dersCalismaDay10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class ActionsClass02 extends TestBase {
    @Test
    public void test(){
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        WebElement videoElementi = driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay-image']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(videoElementi).perform();

        //4- videoyu izlemek icin Play tusuna basin
        actions.click().perform();

        //5- videoyu calistirdiginizi test edin
        WebElement videoCalismaTesti = driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']"));
        Assert.assertTrue(videoCalismaTesti.isDisplayed());
    }
}
