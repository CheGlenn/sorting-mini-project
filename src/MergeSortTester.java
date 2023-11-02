import static org.junit.Assert.assertArrayEquals;
import java.util.Comparator;
import org.junit.Test;

/**
 * Tests of MergeSort.
 */
public class MergeSortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public MergeSortTester() {
    super();
    this.sorter = MergeSort.SORTER;
  } // MergeSortTester()

  @Test
  public void mergeTest(){
    Integer[] arr = {1, 4, 8, 3, 5, 9};
    Integer[] expected = {1, 3, 4, 5, 8, 9};
    Comparator<Integer> compareInts = (x,y) -> x.compareTo(y);
    MergeSort.merge(arr, 0, arr.length, compareInts);
    assertArrayEquals(arr, expected);
    
  }


} // class MergeSortTester
