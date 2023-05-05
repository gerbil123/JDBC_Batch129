import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException , SQLException {


        //drivera kaydol
        Class.forName("org.postgresql.Driver");

        //database e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "felipedesouza");

        //statement olustur
        Statement st = con.createStatement();

        //Soru1: Region id'si 1 olan "country name" değerlerini cağırınız.
        String sql01 = "select country_name from countries where region_id=1";

        //ResultSet
        ResultSet veri = st.executeQuery(sql01);//karşıdan data alırken kullanılır
        while (veri.next()) {
            System.out.println(veri.getString(1));

        }
        System.out.println();
        //Soru 2 :Region id'nin 2 den buyuk oldugu "country id" ve "country name" degerlerini cagirin

        String sql02="select country_id, country_name from countries where region_id>2";
        ResultSet veri2= st.executeQuery(sql02);

        while (veri2.next()) {

            System.out.println(veri2.getString("country_id")
                    + veri2.getString("country_name"));
        }
        con.close();
        st.close();
        veri2.close();
        veri.close();
    }
}
