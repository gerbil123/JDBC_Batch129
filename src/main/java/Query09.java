import pojos.Doctor;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query09 {
    public static void main(String[] args) throws  ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        //database e baglan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "felipedesouza");

        Statement st = con.createStatement();

        //Doktor tablosunu olusturun.
        //String sql01 = "create table doctors(id int, isim varchar(30), bolum varchar(20), ucret int)";
        //st.execute(sql01);

        //POJO class kullanarak tabloya veri ekleyelim
        List<Doctor> kayitlar=new ArrayList<>();
        kayitlar.add(new Doctor(20,"Ali Can","Cildiye",500));
        kayitlar.add(new Doctor(21,"sibel bilen","psikiyatri",800));
        kayitlar.add(new Doctor(22,"serhat guler","ruh sagligi",700));
        kayitlar.add(new Doctor(23,"hediye keskin","noroloji",100));
        kayitlar.add(new Doctor(24,"veli han","kbb",400));
        kayitlar.add(new Doctor(25,"ali han","dermotoloji",500));
        kayitlar.add(new Doctor(26,"hakan bal","ortodonti",500));
        kayitlar.add(new Doctor(27,"mehmet bilen","Cocuk",500));
        kayitlar.add(new Doctor(28,"Ali Can","Cildiye",500));
        PreparedStatement data= con.prepareStatement("insert into doctors values (?,?,?,?)");
        for (Doctor w : kayitlar) {
            data.setInt(1,w.getId());
            data.setString(2, w.getIsim());
            data.setString(3, w.getBolum());
            data.setDouble(4,w.getUcret());

            data.addBatch();//datalari bir araya getirir
        }
        data.executeBatch();//butun verileri gonderir
        con.close();
        data.close();
    }
}
