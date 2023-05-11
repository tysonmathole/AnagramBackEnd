package ControllersTest;

import Application.Anagram.Dao.ReadInputDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

public class ReadInputDaoTest {
    @Autowired
    ReadInputDao readInputDaoClass;

    @Test
    public void readInputTest() throws IOException {
        readInputDaoClass = new ReadInputDao();
        File file = new File("Dictionary.txt");
        String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");
        readInputDaoClass.readInput(fileName);

    }

}
