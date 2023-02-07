package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        /*
        excel dosyalari bilgisayarimizda oldugu icin
        java'dan FileInputStream class'i yardimiyla ulasacagiz
         */
        String dosyaYolu ="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(5).getCell(3));

        /*
        satir ve sutun bilgisini parametre olarak alip
        o hucredeki bilgiyi yazdiran bir method olusturalim
         */

        dataYazdir(3,3);
    }

    private void dataYazdir(int satir, int sutun) throws IOException {
        String dosyaYolu ="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));

    }
}
