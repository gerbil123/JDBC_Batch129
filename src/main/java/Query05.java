import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
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

        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K')

        //int s1 = st.executeUpdate("insert into ogrenciler values (313, 'Sena Can', 12, 'K')");
        //System.out.println(s1 + " satır database eklendi.");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
/*
        String [] veri = {"insert into ogrenciler values  (600, 'Sena Can', 12, 'K')",
                        "insert into ogrenciler values  (601, 'Sena Can', 12, 'K')",
                        "insert into ogrenciler values  (602, 'Sena Can', 12, 'K')"};

        //1. YOL
        int count=0;
        for(String each:veri){
            count = count + st.executeUpdate(each);
        }

        System.out.println( count +" satır eklendi");

        int count = 0;
        for (String w : veri) {
            st.execute(w);
            count++;
        }
        System.out.println(count + " satır eklendi");
*/
        //2. YOL
        String [] veri = {"insert into ogrenciler values  (700, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values  (701, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values  (702, 'Sena Can', 12, 'K')"};

        for(String each:veri){
            st.addBatch(each);  //Yukarıdaki datalırn hepsini birleştiriyor
        }
        st.executeBatch();      //Dataları tek seferde gönderiyor


    }
}