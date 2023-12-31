import java.util.Scanner;

public class TwoDLists {
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        System.out.println("How many Rows?");
        int rows = kb.nextInt();
        System.out.println("How many Columns?");
        int cols = kb.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            // columns
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = kb.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        // printing the twoDList in spiral order

        int rowStart = 0;
        int colStart = 0;
        int rowEnd = rows - 1;
        int colEnd = cols - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int col = colStart; col <= colEnd; col++) {
                System.out.print(matrix[rowStart][col] + " ");
            }
            rowStart++;

            for (int row = rowStart; row <= rowEnd; row++) {
                System.out.print(matrix[row][colEnd] + " ");
            }
            colEnd--;

            for (int col = colEnd; col >= colStart; col--) {
                System.out.print(matrix[rowEnd][col] + " ");
            }
            rowEnd--;

            for (int row = rowEnd; row >= rowStart; row--) {
                System.out.print(matrix[row][colStart] + " ");
            }
            colStart++;

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        // transpose of the matrix
        for (int i = 0; i < rows; i++) {
            // columns
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println("");
        }
    }

}
