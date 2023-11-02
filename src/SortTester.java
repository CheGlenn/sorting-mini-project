import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.beans.Transient;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedStringTest

  @Test
  public void orderedIntTest() {
    Integer[] original = {1, 2, 3, 4, 5};
    Integer[] expected = original.clone();
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedIntTest

  @Test
  public void reverseOrderedIntTest() {
    Integer[] original = {5, 4, 3, 2, 1};
    Integer[] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedIntTest

  @Test
  public void emptyArrayTest() {
    String[] original = {};
    String[] expected = original.clone();
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyArrayTest

  @Test
  public void singleElementArrayTest() {
    String[] original = {"alpha"};
    String[] expected = original.clone();
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // singleElementArrayTest

  @Test
  public void nullValuesTest() {
    String[] original = {"charlie", null, "beta", null, "alpha"};
    String[] expected = {"alpha", "beta", "charlie", null, null};
    sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }
} // class SortTester
