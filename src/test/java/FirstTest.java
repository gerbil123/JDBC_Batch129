import org.junit.Assert;
import org.junit.Test;

public class FirstTest {


        @Test
        public void firstTest01(){
            Assert.assertTrue(6<8);
        }

        @Test
        public void firstTest02(){
                Assert.assertTrue("Test Fail",5<9);
                //Test kaldıgında mesaj alırız.
        }

        @Test
        public void firstTest03(){
                Assert.assertEquals("Sayılar esit değil","6","6");
        }
    }
