package ie.gmit.sw;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Computes the min hash set using (ax + b) % c as a hash function.
 */
public class MinHashCalculatorWithFunction {

    /**
     * Computes and returns the min hash set for the content of a file (words), based on a set of hash values.
     *
     * @param words      the input words.
     * @param hashValues the set of hash values to be applied.
     * @return the set of the min hash values.
     * @throws IOException
     */
    public Set<Integer> computeMinHashes(Set<String> words, Set<HashFunctionCoefficient> hashValues) {

        Set<Integer> minHashValues = new HashSet();
        for (HashFunctionCoefficient hashValue : hashValues) {
            minHashValues.add(computeMinHash(hashValue, words));
        }

        return minHashValues;
    }

    private Integer computeMinHash(HashFunctionCoefficient hashValue, Set<String> words) {
        Integer min = Integer.MAX_VALUE;

        for (String word : words) {
            final Integer hash = (hashValue.getA() * word.hashCode() + hashValue.getB()) % 2957;
            if (hash < min) {
                min = hash;
            }
        }

        return min;
    }
}
