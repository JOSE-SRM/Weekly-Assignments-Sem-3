import java.util.Scanner;

public class TypingAccuracyChecker {

  public static void checkTypingAccuracy(String original, String typed) {
    if (original.length() != typed.length()) {
      System.out.println("Error: The original passage and typed text must be of equal length.");
      return;
    }

    int totalCharacters = original.length();
    int matchedCharacters = 0;

    int firstMismatchPosition = -1;
    char expectedChar = ' ';
    char typedChar = ' ';

    for (int i = 0; i < totalCharacters; i++) {
      if (original.charAt(i) == typed.charAt(i)) {
        matchedCharacters++;
      } else if (firstMismatchPosition == -1) {
        firstMismatchPosition = i + 1;
        expectedChar = original.charAt(i);
        typedChar = typed.charAt(i);
      }
    }

    double accuracy = ((double) matchedCharacters / totalCharacters) * 100;

    if (firstMismatchPosition == -1) {
      System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n",
          matchedCharacters, totalCharacters, accuracy);
    } else {
      System.out.printf("\tMatched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n",
          matchedCharacters, totalCharacters, accuracy, firstMismatchPosition, expectedChar, typedChar);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the original passage: ");
    String original = scanner.nextLine();

    System.out.print("Enter the typed text: ");
    String typed = scanner.nextLine();

    System.out.println("\nChecking Accuracy: ");
    checkTypingAccuracy(original, typed);

    scanner.close();
  }
}
