import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть n: ");
        int n = scanner.nextInt();
        scanner.close();

        int maxPrimeNumber = -1;
        int maxOnesCount = -1;

        for (int i = 2; i <= n; i++) {

            if (isPrimeNumber(i)) {
                String binary = Integer.toBinaryString(i);
                int onesCount = countOnesInBinary(binary);

                if (onesCount > maxOnesCount) {
                    maxOnesCount = onesCount;
                    maxPrimeNumber = i;
                }
            }
        }

        if (maxPrimeNumber != -1) {
            System.out.println("Знайдене число: " + maxPrimeNumber + " - " + Integer.toBinaryString(maxPrimeNumber));
            System.out.println("Кількість одиниць: " + maxOnesCount);
        } else {
            System.out.println("Простих чисел немає");
        }
    }

    private static boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countOnesInBinary(String binary) {
        int count = 0;

        for (char digit : binary.toCharArray()) {
            if (digit == '1') {
                count++;
            }
        }
        return count;
    }
}
