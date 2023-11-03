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


} // class MergeSortTester
