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

  /**
 * Merge the values from positions [lo..mid) and [mid..hi) back into
 * the same part of the array.
 *
 * Preconditions: Each subarray is sorted accorting to comparator.
 */
static <T> void merge(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
  lo = 0;
  hi = vals.length;
  int mid = hi/2; //lo + (hi-lo)/2;
  T[] target = Arrays.copyOf(vals, vals.length);

  while (mid <= hi){
    for (int i = 0; i < target.length; i++){
      if (comparator.compare(vals[lo], vals[mid]) <= 0){
        target[i] = vals[lo];
        lo++;
      } else{
        target[i] = vals[mid];
        mid++;
      }
    }
  }

  vals = target;
} // merge

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {

  } // sort(T[], Comparator<? super T>
} // class MergeSort
