package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {
    /*
    JUnit framework'u calistirilan testlerin passed veya failed olmasini raporlar
    Ancak raporlamanin dogru sonuc vermesi icin
    testlerin Assert class'indanki hazir method'larla  yapilmasi gerekir

    Eger Assert class'i kullanilmazsa
    JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
    C01'de testleri if-else ile yaptigimiz icin
    testler failed olsa da kodlar sorunsuz calistigi icin
    testler Yesil tik olarak isaretlendi
     */

    int p1Yas=60;
    int p2Yas=66;
    int p3Yas=70;

    @Test
    public void test01(){
        //emekli yasi 65 olduguna gore
        //p2Yas'nin emekli olabilecegini test edin
        Assert.assertTrue(p2Yas>65);
    }

    @Test
    public void test02(){
        //emekli yasi 65 olduguna gore
        //p1Yas'nin emekli olamayacagini test edin
        Assert.assertFalse(p1Yas>65);


    }

    @Test
    public void test03(){
        //emekli yasi 65 olduguna gore
        //p3Yas'nin emekli olamayacagini test edin
        Assert.assertFalse("Girilen yas 65 den kucuk olmadigindan emekli olabilir",p2Yas>65);
    }
}
