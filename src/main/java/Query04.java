import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //drivera kaydol
        Class.forName("org.postgresql.Driver");

        //database e baglan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "felipedesouza");

        //statement olustur
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from ogrenciler");

        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Sütun Sayısı: " + rsmd.getColumnCount());
        System.out.println("1. Sütunun ismi : " + rsmd.getColumnName(1));
        System.out.println("2. Sütunun ismi : " + rsmd.getColumnName(2));
        System.out.println("3. Sütunun ismi : " + rsmd.getColumnName(3));
        System.out.println("4. Sütunun ismi : " + rsmd.getColumnName(4));

        System.out.println("Tablo ismi: " + rsmd.getTableName(2)); //sütun sayısı 4 oldugu icin 4 den fazla sayı giremeyiz

        System.out.println(rsmd.getColumnTypeName(1));//int4
        System.out.println(rsmd.getColumnTypeName(2));//varchar

        st.close();
        con.close();
        rs.close();

    }
}
