package dersCalismaDay11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class WaitTest02 extends TestBase {
    @Test
    public void isEnabled(){
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBoxEtkinMiTesti = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxEtkinMiTesti.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement enableButonuElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));
        enableButonuElementi.click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabled = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabled.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        textBoxEtkinMiTesti = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBoxEtkinMiTesti.isEnabled());
    }
}
