import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 4, 2, 0, 9};
        int[] result = findTwosum(arr, 10);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findTwosum(int[] arr, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (temp.containsKey(diff)) {
                return new int[]{temp.get(diff), i};
            }
            temp.put(arr[i], i);
        }
        return new int[]{};
    }
}
