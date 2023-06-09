import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException , SQLException {
        //drivera kaydol
        Class.forName("org.postgresql.Driver");

        //database e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "felipedesouza");

        //statement olustur
        Statement st = con.createStatement();


        //"workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.
        //String sql01 = "Create Table workers(worker_id Varchar(10),worker_name Varchar(20), worker_salary Int)";
        //st.execute(sql01);

        //Table'a worker_address sütunu ekleyin.
//        String sql02 = "Alter Table workers add worker_address Varchar(50)";
//        st.execute(sql02);

        // workers table'ını silin.
        //String sql03 = "Drop table workers";
        //st.execute(sql03);

        //execute() komutunda create , drop , alter table (DDL) icin kullanılır
        st.close();
        con.close();
    }


}
