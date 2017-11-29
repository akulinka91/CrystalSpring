import java.io.IOException;
import java.util.Map;

/**
 * Created by User on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileContent fileContent = new FileContent();
        Map<String, Integer> result = fileContent.mainMethod("D:\\New.txt");
        System.out.println(result);
    }
}
