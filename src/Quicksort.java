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

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   */
  private static <T> void quickSort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    // if (lb >= ub-1) {
    //   return;
    // } else {
    //   int mid = partition(values, order, lb, ub);
    //   quickSort(values, order, lb, mid);
    //   quickSort(values, order, mid+1, ub);
    // } // if/else
  } // quicksort(T[], Comparator, int, int)

  
  // partition

} // class Quicksort
