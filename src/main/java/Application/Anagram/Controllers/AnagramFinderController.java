package Application.Anagram.Controllers;

import Application.Anagram.Dao.AnagramFinderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
@RestController
public class AnagramFinderController {

    @Autowired
    AnagramFinderDao anagramFinderDao;
    @GetMapping("/AnagramResults")
    public String  Anagram(){
        anagramFinderDao = new AnagramFinderDao();
        File file = new File("Dictionary.txt");
        String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");
        String map = anagramFinderDao.countAnagrams(fileName);
        return map;
    }

    @GetMapping("/AnagramMatch")
    public String  AnagramListMatch(String search){
        anagramFinderDao = new AnagramFinderDao();
        File file = new File("Dictionary.txt");
        String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");
        String anagramList = anagramFinderDao.listOfAnagram(search,fileName);
        return anagramList;
    }
}
