import Application.Anagram.Dao.AnagramFinderDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

public class AnagramApplicationTests {

	@Autowired
	AnagramFinderDao anagramFinderDaoObj;
	@Test
	public void countAnagrams()throws IOException {
		anagramFinderDaoObj = new AnagramFinderDao();
		File file = new File("Dictionary.txt");
		String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");

		anagramFinderDaoObj.countAnagrams(fileName);
	}

	@Test
	public void listOfAnagram()throws IOException {
		anagramFinderDaoObj = new AnagramFinderDao();
		File file = new File("Dictionary.txt");
		String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");

		anagramFinderDaoObj.listOfAnagram("AB",fileName);
	}
}
