package dersCalismaDay13;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ReadExcel02 {
    @Test
    public void test01() throws IOException {
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        //- 8.satirdaki 3.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenBilgi =workbook.getSheet("Sayfa1").getRow(7).getCell(2).toString();
        System.out.println(istenenBilgi);

        //- 12.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualDeger =workbook.getSheet("Sayfa1").getRow(11).getCell(3).toString();
        String expectedDeger ="Bakü";
        Assert.assertEquals(expectedDeger,actualDeger);

        //- Satir sayisini bulalim
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()+1);

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        //ingilizce ulke ismi =>Key     geri kalan bilgiler =>Value

        Map<String,String>ulkeBilgileri = new TreeMap<>();
        int sonSatirIndexBilgisi = workbook.getSheet("Sayfa1").getLastRowNum();
        String key="";
        String value="";
        for (int i = 0; i <sonSatirIndexBilgisi ; i++) {
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                  workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                  workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkeBilgileri.put(key,value);
        }
        System.out.println(ulkeBilgileri);
    }
}
