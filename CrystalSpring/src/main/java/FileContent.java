import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 29.11.2017.
 */
public class FileContent {
    public Map<String, Integer> mainMethod(String fileName) throws IOException {
        //создаем поток для для чтения данных из файла
        FileInputStream fileInputStream = new FileInputStream(fileName);
        //создаем поток чтения символов из файла
        Reader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

        //создаем массив символов для хранения содержимого файла
        char[] charArray = new char[fileInputStream.available()];
        //считываем содержимое inputStreamReader и записываем в массив charArray
        while (inputStreamReader.ready()){
            inputStreamReader.read(charArray);
        }
        //закрываем потоки
        fileInputStream.close();
        inputStreamReader.close();

        //преобразовываем массив символов в строку
        String string = "";
        for (int i = 0; i < charArray.length; i++) {
            string = string + charArray[i];
        }

        //из строки создаем массив строк, убирая все знаки препинания, пробелы и символ переноса на следующюю строку
        String[] words = string.replaceAll("\\p{P}", "").split("\\s+");

        //создаем Map для хранения списка слов без дубликатов, во втором параметре будем хранить количество повторений
        Map<String, Integer> map = new HashMap<String, Integer>();

        //заполняем Map значениями из массива words
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        //возвращаем список слов с количеством повторений
        return map;
    }
}
