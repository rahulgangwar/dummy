package exercises.matrix;

public class SpiralOrderMatrix {
    public static void main(String[] args) {
        // test data 1
        int[][] matrix = {{1, 2, 3, 4, 5, 6}, {14, 15, 16, 17, 18, 7}, {13, 12, 11, 10, 9, 8}};

        // test data 2
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        };

        print(4, 4, matrix2);
    }

    private static void print(int totalRows, int totalColumns, int[][] matrix) {
        int startingRow = 0,
                endingRow = totalRows - 1,
                startingCol = 0,
                endingCol = totalColumns - 1;
        while (startingRow <= endingRow && startingCol <= endingCol) {
            printOuterSquare(startingRow, endingRow, startingCol, endingCol, matrix);
            startingRow++;
            startingCol++;
            endingRow--;
            endingCol--;
        }
    }

    private static void printOuterSquare(
            int startingRow, int endingRow, int startingCol, int endingCol, int[][] matrix) {
        // upper row: left to right
        for (int i = startingCol; i <= endingCol; i++) {
            System.out.print(matrix[startingRow][i] + ",");
        }

        // left col: top to bottom
        if (endingRow > startingRow) {
            for (int i = startingRow + 1; i <= endingRow; i++) {
                System.out.print(matrix[i][endingCol] + ",");
            }
        }

        // bottom row: right to left
        if (endingRow > startingRow) {
            for (int i = endingCol - 1; i >= startingCol; i--) {
                System.out.print(matrix[endingRow][i] + ",");
            }
        }

        // left col: bottom to top
        if (endingCol > startingCol) {
            for (int i = endingRow - 1; i > startingRow; i--) {
                System.out.print(matrix[i][startingCol] + ",");
            }
        }
    }
}
