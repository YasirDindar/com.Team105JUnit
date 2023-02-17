package practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q3 extends TestBase {
    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible
        WebElement homeSayfaTesti = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        assertTrue(homeSayfaTesti.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchTesti = driver.findElement(By.xpath("//h2[text()='Contact ']"));
        assertTrue(getInTouchTesti.isDisplayed());

        //6. Enter name, email, subject and message
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        actions.click(name)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("tester")
                .sendKeys(Keys.TAB)
                .sendKeys("qa tester")
                .perform();

        ReusableMethods.bekle(8);
        //7. Upload file
        WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\MerhabaJava.rtf";
        uploadFile.sendKeys(dosyaYolu);

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        ReusableMethods.bekle(5);
        //9. Click OK button
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(2);
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successElementi = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        assertTrue(successElementi.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
        homeSayfaTesti = driver.findElement(By.xpath("(//span[text()='Automation'])[1]"));
        assertTrue(homeSayfaTesti.isDisplayed());
    }
}
