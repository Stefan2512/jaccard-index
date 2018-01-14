package ie.gmit.sw;

import com.google.common.collect.Sets;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Min hash Jaccard approximation solution using (ax + b) % c as a hash function.
 */
public class JaccardFunctionSolution implements JaccardSolution {

    @Override
    public void executeSolution(String firstFilePath, String secondFilePath, Integer k) {

        // Read and parse the input files.
        FileReader fileReader = new FileReader();
        Set<String> firstFileWords;
        Set<String> secondFileWords;

        try {
            firstFileWords = fileReader.readWords(new File(firstFilePath));
            secondFileWords = fileReader.readWords(new File(secondFilePath));
        } catch (IOException e) {
            System.out.println("Could not read input files!");
            return;
        }

        //Generate the hash value set (H)
        HashValueGenerator hashValueGenerator = new HashValueGenerator();
        Set<HashFunctionCoefficient> coefficients = hashValueGenerator.generateHashFunctionCoefficients(k);
        MinHashCalculatorWithFunction minHashCalculatorWithFunction = new MinHashCalculatorWithFunction();

        // Compute the min hash values.
        Set<Integer> firstFileMinHashValues = minHashCalculatorWithFunction.computeMinHashes(firstFileWords, coefficients);
        Set<Integer> secondFileMinHashValues = minHashCalculatorWithFunction.computeMinHashes(secondFileWords, coefficients);

        // Compute the intersection and print the result.
        Set<Integer> intersection = Sets.intersection(firstFileMinHashValues, secondFileMinHashValues);
        System.out.println("Similarity using (ax + b) % c as a hash function: " + intersection.size() / (double) k);
    }
}
