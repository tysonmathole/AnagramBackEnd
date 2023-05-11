package Application.Anagram.Dao;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;
@Component
public class ReadInputDao {

    public ArrayList<String> readInput(String fileName) throws IOException {
        ArrayList<String> dictionary = new ArrayList<>();
        File path = new File(fileName);
        Scanner reader = new Scanner(path);
        while(reader.hasNextLine()){

            dictionary.add(reader.nextLine());
        }
        System.out.println(dictionary.toString());

        reader.close();
        return dictionary;

    }

}
