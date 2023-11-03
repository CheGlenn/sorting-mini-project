import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Your Name Here
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


   @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for(int i = 1; i < values.length; i++){ //loop through array
      
      T temp = values[i]; //set temp val at current index
      int j = i-1; //set counter for index behind current

      if (values[j] != null && temp != null){
        while(j >= 0 && (order.compare(values[j], temp) > 0)){ //check if value at j is greater than current temp
          values[j+1] = values[j]; //switch position of values
          j--; 
        } //while
        values[j+1] = temp; //set value at past j to temp
      }
    } //for
  } //sort
} // class InsertionSort
