import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Chloe Kelly
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter = ChloeKellySort.SORTER;

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
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // reverseOrderedStringTest

  @Test
  public void integerUnorderedTest(){
    Integer[] original = { 5, 6, 1, 19, 3, 7 };
    Integer[] expected = { 1, 3, 5, 6, 7, 19 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // intergerUnorderedTest

  @Test
  public void emptyArray(){
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // emptyArray

  @Test
  public void duplicateVals(){
    Double[] original = {5.5, 5.2, 2.3, 7.6, 5.5, 2.3, 7.6, 5.2};
    Double[] expected = {2.3, 2.3, 5.2, 5.2, 5.5, 5.5, 7.6, 7.6};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // duplicateVals

  @Test
  public void singleVal(){
    String[] original = {"All Alone"};
    String[] expected = {"All Alone"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  }// singleVal

  @Test
  public void mostlySameValues(){
    Integer[] original = {5, 5, 5, 5, 5, 1, 5, 5, 5};
    Integer[] expected = {1, 5, 5, 5, 5, 5, 5, 5, 5};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  }// mostlySameValues

  @Test
  public void longStringArray(){
    String[] original = { "this", "should", "have", "a", "lot", "of", "words", "to", "sort", "hopefully", "i", "can", "sort", "it", "correctly" };
    String[] expected = { "a", "can", "correctly", "have", "hopefully", "i", "it", "lot", "of", "should", "sort", "sort", "this", "to", "words" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  }
} // class SortTester
