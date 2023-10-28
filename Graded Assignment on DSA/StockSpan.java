import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void calculateSpan(int[] prices, int n) {
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        spans[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        System.out.println(Arrays.toString(spans));
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        calculateSpan(prices,n);
    }
}
