import java.util.Random;
import java.util.Scanner;

public class laba_2 {

    private static final int MAX_SIZE = 20;

    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть кількість рядків (не більше " + MAX_SIZE + "): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців (не більше " + MAX_SIZE + "): ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0 || rows > MAX_SIZE || cols > MAX_SIZE) {
            System.out.println("Невірні розміри матриці!");
            return;
        }

        int[][] matrix = new int[rows][cols];


        System.out.println("Оберіть метод заповнення матриці:");
        System.out.println("1 - Введення з клавіатури");
        System.out.println("2 - Рандомне заповнення");
        int choice = scanner.nextInt();

        if (choice == 1) {
            fillMatrixFromKeyboard(matrix, scanner);
        } else if (choice == 2) {
            fillMatrixRandom(matrix);
        } else {
            System.out.println("Невірний вибір!");
            return;
        }


        printMatrix(matrix);


        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.printf("Середнє арифметичне: %.2f%n", average);

        scanner.close();
    }


    private static void fillMatrixFromKeyboard(int[][] matrix, Scanner scanner) {
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }


    private static void fillMatrixRandom(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
    }


    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%5d", num);
            }
            System.out.println();
        }
    }


    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }


    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }


    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }
}
