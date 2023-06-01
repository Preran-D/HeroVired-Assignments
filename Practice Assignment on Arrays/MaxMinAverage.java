import java.util.Arrays;
import java.util.Collections;

public class MaxMinAverage {

  public static void main(String[] args) {
    // Using iterative method
    Integer[] arrNum = { 31, 42, 25, 21, 56, 61, 13, 45, 76, 55 };
    int min = arrNum[0];
    for (int i = 0; i < arrNum.length; i++) {
      if (arrNum[i] < min) {
        min = arrNum[i];
      }
    }
    // using Collections
    int max = Collections.max(Arrays.asList(arrNum));
    System.out.println("The element with the Minimum value: "+min);
    System.out.println("The element with the Maximum value: "+max);

    float sum = 0;
    for (Integer num : arrNum) {
        sum += num;
    }

    int avg = (int)sum /arrNum.length;
    System.out.println("Average of all array elements: "+avg);
    System.out.println("Total number of array elements: " + arrNum.length);

  }
}
