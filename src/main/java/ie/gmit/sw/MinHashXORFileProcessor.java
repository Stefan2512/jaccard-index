package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Computes the min hash values for a input file and a set of precomputed hash values.
 */
public class MinHashXORFileProcessor implements Callable<Set<Integer>> {

    private String filePath;
    private Set<Integer> hashValues;

    public MinHashXORFileProcessor(String filePath, Set<Integer> hashValues) {
        this.filePath = filePath;
        this.hashValues = hashValues;
    }

    public Set<Integer> call() throws IOException {

        // Debug purpose print statement.
        System.out.println("Processing file " + filePath);

        // Read file content and parse words.
        final File inputFile = new File(filePath);
        FileReader fileReader = new FileReader();
        Set<String> fileWords = fileReader.readWords(inputFile);

        // Compute the min hash set for the content of the two files.
        MinHashCalculator minHashCalculator = new MinHashCalculator();
        return minHashCalculator.computeMinHashes(fileWords, hashValues);
    }
}
