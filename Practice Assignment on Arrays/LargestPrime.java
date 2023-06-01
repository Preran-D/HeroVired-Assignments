public class LargestPrime {

  public static void main(String[] args) {
    int[] arrNum = { 2, 29, 51, 8, 4 };
    int LargestPrime = -1;
    for (int i : arrNum) {
      if (isPrime(i) && i > LargestPrime) {
        LargestPrime = i;
      }
    }
    if (LargestPrime == -1){
        System.out.println("No prime number in an array");
    }else{
        System.out.println("The Largest Prime number in given array: "+LargestPrime);
    }
  }

  private static boolean isPrime(int number) {
    if (number <= 1) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }
}
