import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

  public static void findLongestStreak(String signalLog) {
    if (signalLog == null || signalLog.isEmpty()) {
      System.out.println("No signal data provided.");
      return;
    }

    char maxChar = signalLog.charAt(0);
    int maxLength = 1;

    char currentChar = signalLog.charAt(0);
    int currentLength = 1;

    for (int i = 1; i < signalLog.length(); i++) {
      if (signalLog.charAt(i) == currentChar) {
        currentLength++;
      } else {
        currentChar = signalLog.charAt(i);
        currentLength = 1;
      }

      if (currentLength > maxLength) {
        maxLength = currentLength;
        maxChar = currentChar;
      }
    }

    System.out.println("\tLongest Streak: '" + maxChar + "' repeated " + maxLength + " times");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the traffic signal log (e.g., RRGGGYRR): ");
    String signalLog = scanner.nextLine();

    System.out.println("\nAnalyzing Signal Streaks:");
    findLongestStreak(signalLog);

    scanner.close();
  }
}
