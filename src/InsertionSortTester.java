import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests of InsertionSort.
 */
public class InsertionSortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public InsertionSortTester() {
    super();
    this.sorter = InsertionSort.SORTER;
  } // InsertionSortTester()

   @Test
  public void reverseOrderedIntTest() {
    Integer[] original = {5, 4, 3, 2, 1};
    Integer[] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedIntTest

} // class InsertionSortTester
