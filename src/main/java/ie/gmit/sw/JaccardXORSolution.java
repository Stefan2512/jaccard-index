package ie.gmit.sw;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Multi-threaded Jaccar approximation solution using bitwise XOR as a hash function.
 */
public class JaccardXORSolution implements JaccardSolution {


    @Override
    public void executeSolution(String firstFilePath, String secondFilePath, Integer k) {

        //Generate the hash value set (H)
        HashValueGenerator hashValueGenerator = new HashValueGenerator();
        Set<Integer> hashValues = hashValueGenerator.generateHashValues(k);

        // Instantiante executor service and process each file on an own thread.
        ExecutorService executor = Executors.newCachedThreadPool();
        Set<Integer> firstFileMinHashValues;
        Set<Integer> secondFileMinHashValues;

        try {
            Future<Set<Integer>> firstFileExecution = executor.submit(new MinHashXORFileProcessor(firstFilePath, hashValues));
            Future<Set<Integer>> secondFileExecution = executor.submit(new MinHashXORFileProcessor(secondFilePath, hashValues));
            firstFileMinHashValues = firstFileExecution.get();
            secondFileMinHashValues = secondFileExecution.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            executor.shutdown();
            return;
        }

        // Shutdown the executor service.
        executor.shutdown();

        // Compute the intersection and print the Jaccard index.
        Set<Integer> intersection = Sets.intersection(firstFileMinHashValues, secondFileMinHashValues);
        System.out.println("Similarity using bitwise XOR as a hash function: " + intersection.size() / (double) k);
    }
}
