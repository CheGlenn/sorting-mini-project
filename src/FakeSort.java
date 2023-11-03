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


  public static <T> void dualPivotQuickSort(T[] arr, Comparator<? super T> order,  int low, int high) {
    if (low < high) {
        int[] pivots = partition(arr, order, low, high);
        int leftPivotEnd = pivots[0];
        int rightPivotStart = pivots[1];

        dualPivotQuickSort(arr, order, low, leftPivotEnd - 1); // Sort the left subarray
        dualPivotQuickSort(arr, order, leftPivotEnd + 1, rightPivotStart - 1); // Sort the middle subarray
        dualPivotQuickSort(arr, order, rightPivotStart + 1, high); // Sort the right subarray
    }
}  


  public static <T> int[] partition(T[] arr, Comparator<? super T> order, int low, int high){
    if (order.compare(arr[low] , arr[high]) > 0) {
      swap(arr, low, high);
    }
  
    T leftPivot = arr[low];
    T rightPivot = arr[high];

    int i = low + 1;
    int j = high - 1;
    int k = low + 1;

    while (k <= j) {
      if (order.compare(arr[k], leftPivot) < 0) {
          swap(arr, i, k);
          i++;
      } else if (order.compare (arr[k],rightPivot) >= 0) {
          while ((order.compare(arr[j] , rightPivot) > 0) && (k < j)){
              j--;
          }
          swap(arr, k, j);
          j--;
          if (order.compare(arr[k],leftPivot) < 0) {
              swap(arr, i, k);
              i++;
          }
        }
      k++;
    }
    i--;
    j++;

    swap(arr, low, i);
    swap(arr, high, j);

  return new int[]{i, j};
}
  
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values.length <= 1){
      return;
    } else{
      dualPivotQuickSort(values, order, 0, values.length-1);
    }
  } // sort(T[], Comparator<? super T>
} // class FakeSort
  
