import java.sql.*;

public class Query06 {

    public static void main(String[] args)throws ClassNotFoundException, SQLException {

        //drivera kaydol
        Class.forName("org.postgresql.Driver");

        //database e baglan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "felipedesouza");

        //statement olustur
        //Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values(800, 'Ali Can', 11,'E'");

        //Atnı SQL kodlarını kullanacaksak statement degil preparedstatement kullanılır.
        //Statement kullandıgımızda her seferinde kodu database'e iletir
        //PraperedStatement kullandıgımızda ornegi saklar sadece dataları iletir.

        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values(?,?,?,?)");
        ps.setInt(1,871);
        ps.setString(2,"Ali Can");
        ps.setInt(3,11);
        ps.setString(4,"E");
        ps.executeUpdate();

        ps.close();
        con.close();
    }
}
