import java.util.Scanner;

public class WarehouseInventoryBalancer {

  public static void analyzeInventory(int[] sectionA, int[] sectionB) {
    int totalA = 0;
    int totalB = 0;

    int highestQuantity = -1;
    String highestSection = "";
    int highestItemNumber = -1;

    for (int i = 0; i < sectionA.length; i++) {
      totalA += sectionA[i];
      if (sectionA[i] > highestQuantity) {
        highestQuantity = sectionA[i];
        highestSection = "Section A";
        highestItemNumber = i + 1;
      }
    }

    for (int i = 0; i < sectionB.length; i++) {
      totalB += sectionB[i];
      if (sectionB[i] > highestQuantity) {
        highestQuantity = sectionB[i];
        highestSection = "Section B";
        highestItemNumber = i + 1;
      }
    }

    String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

    System.out.printf("\nSection A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
        totalA, totalB, status, highestQuantity, highestSection, highestItemNumber);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of product categories (array length): ");
    int numberOfItems = scanner.nextInt();

    int[] sectionA = new int[numberOfItems];
    int[] sectionB = new int[numberOfItems];

    System.out.println("Enter the " + numberOfItems + " quantities for Section A:");
    for (int i = 0; i < numberOfItems; i++) {
      sectionA[i] = scanner.nextInt();
    }

    System.out.println("Enter the " + numberOfItems + " quantities for Section B:");
    for (int i = 0; i < numberOfItems; i++) {
      sectionB[i] = scanner.nextInt();
    }

    System.out.println("\nInventory Report:");
    analyzeInventory(sectionA, sectionB);

    scanner.close();
  }
}
