package ie.gmit.sw;

/**
 * Interface implemented by different Jaccard approximation solutions.
 */
public interface JaccardSolution {

    /**
     * Executes the specific Jaccard approximation min hash algorithm.
     *
     * @param firstFilePath  first file path.
     * @param secondFilePath second file path.
     * @param k              the k constant.
     */
    void executeSolution(String firstFilePath, String secondFilePath, Integer k);
}
