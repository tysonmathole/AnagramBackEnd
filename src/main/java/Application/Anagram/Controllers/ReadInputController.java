package Application.Anagram.Controllers;

import Application.Anagram.Dao.ReadInputDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ReadInputController {
    @Autowired
    ReadInputDao readInputDao;
    @GetMapping("/readDictionary")

    public String  DisplayDictionaryList()throws IOException {
        readInputDao = new ReadInputDao();
        File file = new File("Dictionary.txt");
        String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");
        ArrayList<String> arr = readInputDao.readInput(fileName);
        return arr.toString();
    }
}
