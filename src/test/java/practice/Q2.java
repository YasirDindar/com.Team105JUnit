package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class Q2 extends TestBase {
    @Test
    public void titleTest(){
        ////              ..Exercise2...

        ////  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String expectedKelime = "Best";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));

    }
    @Test
    public void logoTest(){
        ////  Ayrica Relative Locator kullanarak;
        ////      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement helloHeading = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logoTest = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        Assert.assertTrue(logoTest.isDisplayed());


    }
    @Test
    public void mexicoTest(){
        ////  Ayrica Relative Locator kullanarak;
        ////      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
        WebElement americanLinkTest = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLinkTest = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(americanLinkTest));
        Assert.assertTrue(mexicoLinkTest.isDisplayed());
    }
    @Before
    public void beforeTest(){
        ////  http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
    }

}
