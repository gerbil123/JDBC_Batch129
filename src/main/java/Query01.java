import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //drivera kaydol
        Class.forName("org.postgresql.Driver");

        //database e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","felipedesouza");

        //statement olustur
        Statement st = con.createStatement();

        //ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //Dataları Al
        while(veri.next()){
            System.out.println(veri.getInt(1)
             + veri.getString(2)
             + veri.getString(3)
             + veri.getString(4));
        }
        //Bağlantıları Kapatma
        con.close();
        st.close();
        veri.close();
    }
}