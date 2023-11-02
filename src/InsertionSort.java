import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Chloe Kelly
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
    int i = 1, b = 1;

    while(i < values.length){
      if(order.compare(values[i-1], values[i]) > 0){
        //Save values and init barrier
        T tmp = values[i];
        b = i-1;
        do {
          //Shift elements
          values[b+1] = values[b];
          b--;
        } while(b >= 0 && order.compare(values[b], tmp)> 0);
        //Put value where it belongs
        values[b+1] = tmp;
      }//if
      i++;
    } //while
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
