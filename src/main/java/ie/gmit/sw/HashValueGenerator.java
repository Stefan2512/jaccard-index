package ie.gmit.sw;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Class responsible for the hash value generation.
 */
public class HashValueGenerator {

    /**
     * Generates and returs k random hash values.
     *
     * @param k the number of hash functions to be generated.
     * @return the generated set of k hash values.
     */
    public Set<Integer> generateHashValues(final int k) {

        Set<Integer> hashValues = new HashSet();
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            // limit the random numbers to 32.
            hashValues.add(random.nextInt(32));
        }

        return hashValues;
    }

    /**
     * Generates and returns k random a and b values for the (ax + b) % c hash function.
     *
     * @param k the number of coefficient pairs to be generated.
     * @return the generated coefficients.
     */
    public Set<HashFunctionCoefficient> generateHashFunctionCoefficients(final int k) {
        Set<HashFunctionCoefficient> hashValues = new HashSet();
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            hashValues.add(new HashFunctionCoefficient(random.nextInt(), random.nextInt()));
        }

        return hashValues;
    }
}
