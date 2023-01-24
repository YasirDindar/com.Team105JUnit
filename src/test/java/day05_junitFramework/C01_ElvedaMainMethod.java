package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {

    @Test
    public void test01(){
        System.out.println("test01 calisti");
        /*
        @Test notasyonu sayesinde her bir test methodu bagimsiz olarak calisabilir
        eger testin icersinde bir assertion yoksa
        kod problem yasanmadan calisip bittiginde
        JUnit test PASSED olarak raporlar.
         */
    }
    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
        /*
        @Ignore notasyone yazildigi test methodun calistirilmamasini saglar
         */
    }
    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }
}
