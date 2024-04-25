import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program reads and writes to a file the sum of a set of ints.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-04-01
 */

// sourced from https://chat.openai.com
@SuppressWarnings("HideUtilityClassConstructor")
public final class ReverseString {
  /** Constructor for the ReverseString class. */
  public ReverseString() {
    // empty constructor
  }

  /**
   * Calculates the sum of integers from a string array.
   *
   * @param fileArrayStr Array of strings representing integers.
   * @return String representation of the sum.
   */
  public static String revString(final String str, String output, final int n) {
    if (n < 0) {
      return output;
    } else {
      output += str.charAt(n);
      return revString(str, output, n - 1);
    }
  }

  /**
   * Reads input from a file, reverses string, and write to an output file.
   *
   * @param args Command line arguments (unused).
   */
  public static void main(final String[] args) {
    try {
      // File paths
      String in = "Unit3/Unit3-01/Unit3-01-Java-ReverseString/input.txt";
      String out = "Unit3/Unit3-01/Unit3-01-Java-ReverseString/output.txt";
      File inputFile = new File(in);
      File outputFile = new File(out);

      // Initializing scanner and writer
      Scanner scanner = new Scanner(inputFile);
      FileWriter writer = new FileWriter(outputFile);

      // variables
      String fileLine;

      // loops until there is nothing to read
      while (scanner.hasNextLine()) {
        // reads a single line
        fileLine = scanner.nextLine();

        // call the recursive function
        String result = revString(fileLine, "", fileLine.length() - 1);

        // write to file
        writer.write(result + "\n");
      }
      // message to console confirming the process finished with no errors
      System.out.println("Successfully completed task!");

      // close scanner and writer
      scanner.close();
      writer.close();

      // file could not be found
    } catch (IOException e) {
      System.out.println("The file does not exists.");
    }
  }
}
