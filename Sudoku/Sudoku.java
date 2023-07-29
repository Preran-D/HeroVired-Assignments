package Sudoko;

class Sudoko {
    private static final int size = 9;


    public static void main(String[] args) {

        int[][] board = {
                {3, 1, 6, 5, 7, 8, 4, 9, 2},
                {5, 2, 9, 1, 3, 4, 7, 6, 8},
                {4, 8, 7, 6, 2, 9, 5, 3, 1},
                {2, 6, 3, 4, 1, 5, 9, 8, 7},
                {9, 7, 4, 8, 6, 3, 1, 2, 5},
                {8, 5, 1, 7, 9, 2, 6, 4, 3},
                {1, 3, 8, 9, 4, 7, 2, 5, 6},
                {6, 9, 2, 3, 5, 1, 8, 7, 4},
                {7, 4, 5, 2, 8, 6, 3, 1, 9}
        };


        if (isValidSudoku(board)) {
            System.out.println("Valid Sudoku!");
        } else {
            System.out.println("Invalid Sudoku!");
        }
    }


    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInCol(int[][] board, int number, int col) {
        for (int i = 0; i < size; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int col) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int number, int row, int col) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInCol(board, number, col) &&
                !isNumberInBox(board, number, row, col);
    }

    private static boolean isValidSudoku(int[][] board) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] != 0) {
                    int currentNumber = board[row][col];
                    board[row][col] = 0; /* Made zero to exclude that number**/
                    if (!isValid(board, currentNumber, row, col)) {
                        return false;
                    }
                    board[row][col] = currentNumber;
                }
            }
        }
        return true;
    }
}