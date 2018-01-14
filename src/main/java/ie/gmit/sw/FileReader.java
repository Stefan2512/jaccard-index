package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Helper class for reading the input files and parsing the words.F
 */
public class FileReader {

    /**
     * Reads and parses the input file.
     *
     * @param file the input file.
     * @return a set containing the words from the input file.
     * @throws IOException
     */
    public Set<String> readWords(File file) throws IOException {
        Set<String> words = new HashSet();
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            words.add(input.next());
        }
        return words;
    }
}
