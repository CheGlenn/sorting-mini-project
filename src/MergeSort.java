import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Your Name Here
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

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

/* Sort checks if array is already sorted and calls mergeSort method
 * pre: Array, comparator
 */
@Override
public <T> void sort(T[] values, Comparator<? super T> order) {
  if (values.length <= 1){ //check if array is 1 val or less, if so its already sorted and we dont have to do anything
    return;
  } else {
    mergeSort(values, order, 0, values.length); //if not begin mergeSort
  } //else

} // sort(T[], Comparator<? super T>

/*
 * Merge sort sorts parts of an array using a low value, high value, and mid as counters
 * pre: Array, comparator, lower bound in range of Array, upperbound in range of Array
 * 
 */
public static <T> void mergeSort(T[] vals, Comparator<? super T> order, int lb, int ub){
  if (lb < ub){ //check if lb is less than ub

    //set counters for navigating array
    int lo = lb; 
    int hi = ub-1;
    int mid = lb + (ub - lb)/2;

    while (lo < mid){ //check if low has reached mid
      if(order.compare(vals[lo], vals[lo+1]) > 0){ //compare val at low to next val
        swap(vals, lo, lo+1); //swap if val at low is larger
      }//if
      lo++; //either way, incrament low 
    }//while

    while (mid < hi){ //check if mid has reached hi
      if(order.compare(vals[mid], vals[mid+1]) > 0){ //compare val at mid to next val
        swap(vals, mid, mid+1); //swap if val at mid is larger
      } //if
      mid++; //either way, incrament low
    } //while
    //call merge sort on each sorted half of array
    mergeSort(vals, order, lb, mid); 
    mergeSort(vals, order, mid+1, ub);

  }//if
}//mergeSort

/**
 * Merge the values from positions [lo..mid) and [mid..hi) back into
 * the same part of the array.
 *
 * Preconditions: Each subarray is sorted accorting to comparator.
 */
static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
  
  //counters for navigation
  int left = lo;
  int right = mid+1;
  int current = lo;


  T[] target = Arrays.copyOf(vals, vals.length); //target array


  while ((left <= mid) && (right <= hi-1)){ //check if left has reached mid point, or if right has reached end of array

      if (comparator.compare(vals[left], vals[right]) <= 0){ //compare unsorted value on left to value on right, 

        target[current] = vals[left]; //if left is smaller or equal to right, set target at i equal to left val
        left++; //incrament left

      } //if 
       else{

        target[current] = vals[right]; //uf right is smaller than left, set target at i equal to right val
        right++; //incrament right
      } //else

      current++; //incrament current
    
  }//while

  while(left < mid+1){ //check if left has reached mid

      target[current] = vals[left]; //copy over
      current++; //incrament counters
      left++;
    
  }//while

  while(right < hi){ //check if right has reached high
    target[current] = vals[right]; //copy over
    current++; //incrament counters
    right++;
  }//while

  for(int i = left; i <= right; i++){ //loop through target array and copy to original array

    vals[i] = target[i];
  }//for
} // merge


  
} // class MergeSort
