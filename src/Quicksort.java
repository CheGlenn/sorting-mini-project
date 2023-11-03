import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

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
   * Partition finds and returns the index for a partition value, and sorts the array around that value
   */
  public <T> int partition(T[] values, int lb, int ub, Comparator<? super T> comparator){
    
    int pivot = lb + (ub-lb)/2; //set pivot as midpoint

    int small = lb+1; //set small
    int large = ub; //set large

    swap(values, pivot, lb); //place pivot at start of the array, swapping 

    while(small != large){ //check if small and large have met

      if (comparator.compare(values[small], values[lb]) > 0 ){ //compare values
        swap(values, small, large-1); //swap small and large if small is greater
        large--; //decrease large
      } else{
        small++; //if large is greater, incrament large
      }
    }

    swap(values, lb, small-1); //swap pivot into the mid

    return small-1; //return position of the pivot

  }
  /*
   * Main quick sort function, checks if array is sorted and calls quickSort method
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {

    if(values.length <= 1){ //check if array is empty or has only 1 element (is already sorted)
      return;
    } else{

    quickSort(values, order, 0, values.length); //run quick sort

    }

  } // sort(T[], Comparator<? super T>

  /*
   * checks if there are values still to be sorted, and recursively calls quickSort on unsorted halves of the array
   */
  public <T> void quickSort(T[] values, Comparator<? super T> order, int lb, int ub){

    if(lb >= ub-1){ //check if there are values left to be sorted
      return;
      
    } else{
      int mid = partition(values, lb, ub, order); //set the mid as the partitioned value

      quickSort(values,order, lb, mid); //call quicksort on left half
      quickSort(values, order, mid+1, ub); //call quicksort on right half
    }
  }
} // class Quicksort
