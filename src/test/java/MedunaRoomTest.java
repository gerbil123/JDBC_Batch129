import org.junit.Assert;
import org.junit.Test;
import utilities.JdbcUtils;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunaRoomTest {

    //"john_doe" isimde bir kullanıcı tarafından oda oluşturulmu mu?

    @Test
    public void roomTest() throws SQLException {

        JdbcUtils.connectToDataBase(
                "medunna.com",
                "medunna_db",
                "medunna_user",
                "medunna_pass_987");

        Statement statement = JdbcUtils.createStatement();
        String sql01="select created_by from room";

        ResultSet rs = statement.executeQuery(sql01);
        List<String> created_byList=new ArrayList<>();

        while(rs.next()){
            created_byList.add(rs.getString(1));
        }
        System.out.println("ODA OLUSTURANLAR: " + created_byList);

        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",created_byList.contains("john_doe"));

        JdbcUtils.closeConnectionAndStatement();
    }
}
