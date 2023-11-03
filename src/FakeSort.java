import java.util.Comparator;

/**
 * Something that fails to sort.  Intended primarily to allow us to wath
 * tests fail.
 *
 * @author Samuel A. Rebelsky
 */

public class FakeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new FakeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  FakeSort() {
  } // FakeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /*
   * Swaps values in an Array at two specified indicies
   * pre: Array, int i <= Array.length-1, int j <= Array.length-1
   * post: 
   */
  public static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /*
   * Helper for sort, defines pivots in array and recursively calls to keep sorting sections of array
   * pre: Array, comparator, low in range of Array, high in rande of array
   */
  public static <T> void dualPivotQuickSort(T[] arr, Comparator<? super T> order,  int low, int high) {
    if (low < high) { //check if there is more values to sort
        int[] pivots = partition(arr, order, low, high); //the index of our two pivots
        int leftPivotEnd = pivots[0]; 
        int rightPivotStart = pivots[1];

        dualPivotQuickSort(arr, order, low, leftPivotEnd - 1); // Sort the left subarray
        dualPivotQuickSort(arr, order, leftPivotEnd + 1, rightPivotStart - 1); // Sort the middle subarray
        dualPivotQuickSort(arr, order, rightPivotStart + 1, high); // Sort the right subarray
    }
}  

  /*
   * This partition identifies two pivots in an array, but besides that works similarly to Quicksort.java. Array is split up into three pieces instead of two halves
   * those smaller than leftPivot, bigger than rightPivot, and everything in between
   * pre: Array, comparator, low in range of Array, high in range of array
   */
  public static <T> int[] partition(T[] arr, Comparator<? super T> order, int low, int high){
    if (order.compare(arr[low] , arr[high]) > 0) { //check if the lowest val in array is larger than the highest val in the array
      swap(arr, low, high); //swap
    }
    
    //define pivots
    T leftPivot = arr[low]; 
    T rightPivot = arr[high];

    //counters to move arround array
    int small = low + 1;
    int large = high - 1;
    int current = low + 1;

    while (current <= large) { //check to see if we are at the end of unsorted values
      if (order.compare(arr[current], leftPivot) < 0) { //check if current val is smaller than left pivot
          swap(arr, small, current); //swap
          small++; //move small counter
      } else if (order.compare (arr[current],rightPivot) >= 0) { //check if current counter is greater than or equal to right pivot
          while ((order.compare(arr[large] , rightPivot) > 0) && (current < large)){ //make sure that largest value is greater than right pivot, and that current is not at the end of the array
              large--; //move large counter
          }
          swap(arr, current, large); //if we arent at the end of the array or if current large is greater than the right pivot
          large--; //move large counter
          if (order.compare(arr[current],leftPivot) < 0) { //if current is less than left pivot 
              swap(arr, small, current); //swap
              small++; //move small counter
          }
        }
      current++; //no matter what, current counter is moved upp
    }
    small--;
    large++;

    swap(arr, low, small);
    swap(arr, high, large);

  return new int[]{small, large}; //return pivot indicies
}
  /*
   * Main sort method, checks if array is already sorted and calls dualPivotQuickSort
   * pre: Array, comparator
   * post:
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values.length <= 1){
      return;
    } else{
      dualPivotQuickSort(values, order, 0, values.length-1);
    }
  } // sort(T[], Comparator<? super T>
} // class FakeSort
  
