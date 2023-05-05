import static utilities.DatabaseUtilty.*;

public class Query08 {

    public static void main(String[] args) {


        createConnection();

        String sql01 = "select * from ogrenciler";
        System.out.println("Sütun isimler: " + getColumnNames(sql01));
        System.out.println(getColumnData(sql01, "okul_no"));

        System.out.println("Okul No: " + getColumnData(sql01, "okul_no"));
        System.out.println("Ogrenci ismi: " + getColumnData(sql01, "ogrenci_ismi"));
        System.out.println("SINIF: " + getColumnData(sql01, "sinif"));
    }
}
