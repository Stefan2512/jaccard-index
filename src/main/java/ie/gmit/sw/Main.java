package ie.gmit.sw;


import java.io.IOException;
import java.util.Scanner;

/**
 * Main class of the application.
 */
public class Main {

    public static final int K = 4;

    public static void main(String args[]) {

        // Display the menu and read the input paths.
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Enter file name / URL 1 > ");
        final String firstFilePath = inputReader.nextLine();
        System.out.println("Enter file name / URL 2 > ");
        final String secondFilePath = inputReader.nextLine();

        System.out.println("Processing...");

        // Execute the solution using XOR as a hash function (multi-threaded).
        JaccardSolution jaccardSolution = new JaccardXORSolution();
        jaccardSolution.executeSolution(firstFilePath, secondFilePath, K);

        // Compute the same Jaccard index using (ax + b % c) as a hash function.
        jaccardSolution = new JaccardFunctionSolution();
        jaccardSolution.executeSolution(firstFilePath, secondFilePath, K);
    }
}
