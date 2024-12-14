import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of memory blocks:");
        int n = scanner.nextInt();
        int[] memoryBlocks = new int[n];

        System.out.println("Enter the sizes of the memory blocks:");
        for (int i = 0; i < n; i++) {
            memoryBlocks[i] = scanner.nextInt();
        }

        while (true) {
            System.out.println("Enter process size to allocate (or -1 to exit):");
            int processSize = scanner.nextInt();

            if (processSize == -1) {
                break;
            }

            int largestBlockIndex = -1;
            int largestBlockSize = -1;

            // Find the largest block
            for (int i = 0; i < n; i++) {
                if (memoryBlocks[i] >= processSize && memoryBlocks[i] > largestBlockSize) {
                    largestBlockSize = memoryBlocks[i];
                    largestBlockIndex = i;
                }
            }

            if (largestBlockIndex != -1) {
                memoryBlocks[largestBlockIndex] -= processSize;
                System.out.println("Allocated process of size " + processSize + " to block " + largestBlockIndex);
            } else {
                System.out.println("No suitable block found for process of size " + processSize);
            }

            // Display current memory block status
            System.out.println("Current memory block sizes:");
            for (int i = 0; i < n; i++) {
                System.out.println("Block " + i + ": " + memoryBlocks[i]);
            }
        }

        scanner.close();
    }
}