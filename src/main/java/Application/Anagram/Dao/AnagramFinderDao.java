package Application.Anagram.Dao;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class AnagramFinderDao {

    /**
     * Reads a dictionary file and counts the number of anagrams for each word length.
     *
     * @param filename the path to the dictionary file
     * @return a map from word length to the number of anagrams found
     */
    public  String countAnagrams(String filename) {
        long startTime = System.nanoTime();
        Map<Integer, Integer> anagramCounts = new HashMap<>();
        String mapDisplay = "" ;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;
            ArrayList<String> arr = new ArrayList<>();
            while ((word = reader.readLine()) != null) {

                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sortedWord = new String(chars);
                arr.add(sortedWord);

            }

            Map<String, Integer> frequency = new HashMap<>();

            // Iterate over each element in the list
            for (String element : arr) {
                // Get the current count of this element
                int count = frequency.getOrDefault(element, 0);

                // Frequency of each Word
                frequency.put(element, count + 1);
                //If frequency of that word is > 1 we store it on AnagramCount Map

            }
            //Save frequencies greater than 1 from frequency map to AnagramCount Map
            for (var element : frequency.entrySet()) {
                if (element.getValue() > 1)
                    anagramCounts.put((element.getKey()).length(),anagramCounts.getOrDefault((element.getKey()).length(),0)+element.getValue());
            }
            // Print the frequency of each element in the list
            System.out.println("Anagram counts:");
            for (Map.Entry<Integer, Integer> entry : anagramCounts.entrySet()) {
                System.out.println("Words with the character length of: " +entry.getKey()+ " had " + entry.getValue() + " anagrams");
                mapDisplay+="Words with the character length of: " +entry.getKey()+ " had " + entry.getValue() + " anagrams.<br>" ;
            }


        } catch (IOException e) {
            System.err.println("Error reading dictionary file: " + e.getMessage());
        }
        long endTime = System.nanoTime();

        // Calculate the elapsed time in milliseconds
        long elapsedTimeMs = (endTime - startTime) / 1000000;
        System.out.println("Total time in milliseconds "+elapsedTimeMs+"ms");
        mapDisplay+="Total time in milliseconds "+elapsedTimeMs+"ms";

        return mapDisplay;
    }

    public String listOfAnagram(String anagramMatch, String filename) {
        long startTime = System.nanoTime();
        Map<Integer, Integer> anagramCounts = new HashMap<>();
        ArrayList<String> anagramMatches = new ArrayList<>();
        String displayListAnagram = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;
            ArrayList<String> arr = new ArrayList<>();
            while ((word = reader.readLine()) != null) {
                arr.add(word);
            }

            for (int i = 0; i < arr.size(); i++) {
                char[] chars = arr.get(i).toCharArray();
                char[] anagramMatchSort = anagramMatch.toCharArray();
                Arrays.sort(chars);
                Arrays.sort(anagramMatchSort);
                String sortedWordAnagramMatch = new String(anagramMatchSort);
                String sortedWord = new String(chars);

                if (sortedWord.equals(sortedWordAnagramMatch)) {
                    anagramMatches.add(arr.get(i));
                }
            }
            // Iterate over each element in the list
            for (String element : anagramMatches) {
                // Get the current count of this element
                System.out.println(element);
                displayListAnagram+=element+"<br>";
            }
            long endTime = System.nanoTime();

            // Calculate the elapsed time in milliseconds
            long elapsedTimeMs = (endTime - startTime) / 1000000;
            System.out.println("Total time in milliseconds " + elapsedTimeMs + "ms");
            displayListAnagram+="Total time in milliseconds " + elapsedTimeMs + "ms";
        } catch (IOException e) {
            System.err.println("Error reading dictionary file: " + e.getMessage());
        }
        return displayListAnagram;

    }

}
