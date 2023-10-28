import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        setZeros(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeros(int[][] matrix) {
        Set<Integer> setZeroes = new HashSet<>();
        Set<Integer> setColumn = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    setZeroes.add(i);
                    setColumn.add(j);
                }

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (setZeroes.contains(i) || setColumn.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }


    }
}
