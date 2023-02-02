package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {
        String dosyaYolu ="C:\\Users\\yasir\\Desktop\\MerhabaJava.rtf";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        /*
        File testlerinde genellikle downloads'a indirilecek bir dosyanin
        indirildigini test etmek
        veya masaustundeki bir dosyanin web'e yuklenebildigini test etmek isteriz
        ancak herkesin bilgisayarinin ismi, kullanici isimleri gibi farkliliklar
        olacagindan testler tek bir bilgisayarda calisacak gibi yazilmak zorunda kalinir.

        bu karisikligin onune gecebilmek icin java 2 basit kod bulogu sunmustur
        1-
         */
        System.out.println(System.getProperty("user.dir"));
        //o anda calisan dosyanin ( C01_FileInputStream) yolunu verir.
        //C:\Users\yasir\IdeaProjects\com.Team105JUnit

        System.out.println(System.getProperty("user.home"));
        //kullanicinin temel path'ini verir
        //C:\Users\yasir

        //masaustune gitmek istersek
        //  C:\Users\yasir + \Dekstop eklmemiz gerekir
        //dowlands'a gitmek istersek
        //  C:\Users\yasir + \Downloads eklmemiz gerekir

        /*
        kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        kullanici adi gibi detaylara takilmamasi icin
        file testlerinde kullanilacak dosya yolunu
        user.home... temel path'ini calistigi bilgisayardan alacak
        sekilde olustururuz
         */
        String dinamikDosyaYolu =System.getProperty("user.home")+ "\\Desktop\\MerhabaJava.rtf";
    }
}
