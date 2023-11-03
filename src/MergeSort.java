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

  

@Override
public <T> void sort(T[] values, Comparator<? super T> order) {
  if (values.length <= 1){
    return;
  } else {
    mergeSort(values, order, 0, values.length-1);
  }

} // sort(T[], Comparator<? super T>

public static <T> void mergeSort(T[] vals, Comparator<? super T> order, int lb, int ub){
  if (lb < ub){
    int mid = lb + (ub - lb)/2;
    mergeSort(vals, order, lb, mid);
    mergeSort(vals, order, mid+1, ub);

    merge(vals,lb, mid, ub, order);
  }
}

/**
 * Merge the values from positions [lo..mid) and [mid..hi) back into
 * the same part of the array.
 *
 * Preconditions: Each subarray is sorted accorting to comparator.
 */
static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
  
  int left = lo;
  int right = mid+1;
  int current = lo;


  T[] target = Arrays.copyOf(vals, vals.length); //target array

  for(int i = left; i <= right; i++){ //loop through target array and copy to original array

    vals[i] = target[i];
  }

  while ((left <= mid) && (right <= hi)){ //check if left has reached mid point, or if right has reached end of array

      if (comparator.compare(vals[left], vals[right]) <= 0){ //compare unsorted value on left to value on right, 

        target[current] = vals[left]; //if left is smaller or equal to right, set target at i equal to left val
        left++; //incrament left

      } else{

        target[current] = vals[right]; //uf right is smaller than left, set target at i equal to right val
        right++; //incrament right
      }

      current++;
    
  }

  while(left <= mid){ //check if left has reached mid

      target[current] = vals[left]; //copy over
      current++;
      left++;
    
  }
} // merge


  
} // class MergeSort
