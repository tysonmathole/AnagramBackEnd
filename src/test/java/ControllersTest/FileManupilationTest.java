package ControllersTest;

import Application.Anagram.Dao.FileManupilationDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import  java.io.IOException;


public class FileManupilationTest {

    @Autowired
    FileManupilationDao fileManupilationDaoObj;


    @Test
    public void writeToFile()throws  IOException{
        fileManupilationDaoObj = new FileManupilationDao();
        fileManupilationDaoObj.writeToFile("Tyyyy");
    }
    @Test
    public void deleteWordTest()throws  IOException{
        fileManupilationDaoObj = new FileManupilationDao();
        fileManupilationDaoObj.deleteFromFile("AB");
    }


}
