package Application.Anagram.Dao;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

@Component
public  class FileManupilationDao {

    public  String deleteFromFile(String search)throws IOException {
        File file = new File("Dictionary.txt");
        String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");
        File inputFile = new File(fileName);
                File tempFile = new File("temp.txt");
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writers = new BufferedWriter(new FileWriter(tempFile));
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    String modifiedLine = currentLine.replaceAll(search, "");
                    if(!modifiedLine.equals(""))
                    writers.write(modifiedLine + System.getProperty("line.separator"));
                }
                reader.close();
                writers.close();
                inputFile.delete();
                tempFile.renameTo(inputFile);
                System.out.println("word "+search + " deleted");
               return "Word deleted successfully.";

    }
    public void writeToFile(String word) throws IOException{
        File file = new File("Dictionary.txt");
        String fileName = file.getAbsolutePath().replaceAll("\\\\","\\\\\\\\");

        try{
            // BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            FileWriter writer= new FileWriter(fileName, true);
            writer.write("\n");
            writer.write(word);
            System.out.println("word "+word+" added to dictionary");
            writer.close();
        }
        catch (IOException e){
            e.getStackTrace();
        }

    }

}
