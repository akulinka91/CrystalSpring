import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by User on 29.11.2017.
 */
public class FileContentTest {
    @org.junit.Test
    public void mainMethod() throws Exception {
        FileContent fileContent = new FileContent();
        Map<String, Integer> actual = fileContent.mainMethod("D:\\New.txt");
        Map<String, Integer> expected = new HashMap<String, Integer>(){{
            put("Amsterdam",2);
            put("Vienna",1);
            put("NewYork",1);
            put("Melburn",1);
            put("Almaty",1);
            put("Moscow",2);
        }};
        //проверяем наш метод на корректность возвращаемых данных
        assertEquals(expected, actual);
    }

}