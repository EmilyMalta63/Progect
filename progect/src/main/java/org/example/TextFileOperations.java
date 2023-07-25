import java.io.*;
import java.util.*;

public class TextFileOperations {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java TextFileOperations <input_file1> <input_file2>");
            System.exit(1);
        }

        String inputFilePath1 = args[0];
        String inputFilePath2 = args[1];

        // Read the content of the input files
        List<String> file1Lines = readFile(inputFilePath1);
        List<String> file2Lines = readFile(inputFilePath2);

        // Sort the lines of both files
        Collections.sort(file1Lines);
        Collections.sort(file2Lines);

        // Merge the content of the two files
        List<String> mergedLines = new ArrayList<>(file1Lines);
        mergedLines.addAll(file2Lines);

        // Find unique lines
        Set<String> uniqueLines = new HashSet<>(mergedLines);

        // Output the results
        System.out.println("Sorted content of " + inputFilePath1 + ":");
        printLines(file1Lines);

        System.out.println("\nSorted content of " + inputFilePath2 + ":");
        printLines(file2Lines);

        System.out.println("\nMerged content of both files:");
        printLines(mergedLines);

        System.out.println("\nUnique lines in both files:");
        printLines(new ArrayList<>(uniqueLines));
    }

    // Read lines from a text file and return them as a list of strings
    private static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            System.exit(1);
        }
        return lines;
    }

    // Print lines from a list
    private static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}