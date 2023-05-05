import org.junit.Assert;
import org.junit.Test;

import static utilities.DatabaseUtilty.*;


public class JUnit_Test {
    @Test
    public void test01() {
        //Derya Soylu ve Ahmet Aslan İSİMLİ ÖĞRENCİLER DATABASE DE VAR MI?

        //import utilities.DatabaseUtilty;
        //DatabaseUtilty.createConnection();
        createConnection();
        String sql01 = "select * from ogrenciler";
        System.out.println(getColumnData(sql01, "ogrenci_ismi"));
        Assert.assertTrue("Database'de KAYIT BULUNAMADI",
                getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu"));
        //Assert.assertTrue(getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu"));

        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData(sql01, "ogrenci_ismi").contains("Ahmet Aslan"));
        //getColumnData(query, "sutun ismi"): Sütındaki bütün dataları verir.

        closeConnection();
    }

    @Test
    public void test02() {

        //118 numaralı öğrenci databaede var mı?
        createConnection();
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData("select * from ogrenciler", "okul_no").contains(118));
        closeConnection();
    }

}