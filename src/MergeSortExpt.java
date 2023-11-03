import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Arrays;



public class MergeSortExpt {

  public static void main(String[] args){
    Integer[] original = {1, 4, 8, 3, 5, 9};

    Comparator<Integer> compareInts = (x,y) -> x.compareTo(y);

    int[] arr = {12, 11, 13, 5, 6, 7};
    System.out.println("Original array: " + Arrays.toString(arr));
    MergeSort(arr);
    System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    

  }
  
}
