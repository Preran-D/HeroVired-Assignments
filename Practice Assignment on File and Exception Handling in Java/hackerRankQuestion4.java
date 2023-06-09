import java.util.Scanner;

public class hackerRankQuestion4 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while(scan.hasNextLine()){
            int n = scan.nextInt();
            int p = scan.nextInt();

            try {
                System.out.println(power(n,p));
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
    private static int power(int n, int p) throws Exception {
        if (n < 0 || p < 0){
            throw  new Exception("n or p should not be negative.");
        }

        if (n == p && p == 0){
            throw  new Exception("n and p should not be zero.");
        }

        return (int) Math.pow(n, p);
    }
}
