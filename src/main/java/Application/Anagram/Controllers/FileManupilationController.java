package Application.Anagram.Controllers;
import Application.Anagram.Dao.FileManupilationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class FileManupilationController {
    @Autowired
    FileManupilationDao fileManupilationDaoObj;

    @GetMapping( "/add")
    public String add(@RequestParam String word) throws IOException {
        fileManupilationDaoObj = new FileManupilationDao();
        fileManupilationDaoObj.writeToFile(word);
        System.out.println(word);
        return "Your word has been suceefully added";
        //http://localhost:8080/add?word=abc


    }

    @GetMapping( "/deleteFromFile")
    public String delete(@RequestParam String search) throws IOException {
        fileManupilationDaoObj = new FileManupilationDao();
        fileManupilationDaoObj.deleteFromFile(search);
        return "Your word has been suceefully deleted";
        //http://localhost:8080/add?word=abc


    }
}
