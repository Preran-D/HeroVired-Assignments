public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 3, 12};
        moveZeros(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeros(int[] arr) {
        int n = arr.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) arr[j++] = arr[i];
        }

        while (j < n) {
            arr[j++] = 0;
        }

    }
}
