import java.util.Comparator;

/**
 * My own sorting algorithm. Which is actually quicksort with a median pivot (I think)
 * Algorithms are hard.
 *
 * @author Chloe Kelly
 */

public class ChloeKellySort extends Quicksort {

  public static Sorter SORTER = new ChloeKellySort();

  /**
   * Create a sorter.
   */
  ChloeKellySort() {
  } // ChloeKellySort()

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   */
  private static <T> void quickSort(T[] values, Comparator<? super T> order, int lb, int ub) {
    //Subarrays of one element or fewer are sorted.
    if (ub - lb <= 1) {
      return;
    } else {
      int mid = partition(values, order, lb, ub);
      quickSort(values, order, lb, mid);
      quickSort(values, order, mid+1, ub); 
    } // if/else
  } // quicksort(T[], Comparator, int, int)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  static <T> int partition(T[] vals, Comparator<? super T> order, int lb, int ub) {
    //Pick pivot
    int mid = median(vals, lb, ub, order);
    //init small and large
    int small = lb+1;
    int large = ub-1;

    swap(vals, mid, lb);

    while(small <= large){  
      if(order.compare(vals[small], vals[lb]) < 0){
        small++;
      }
      else{
        swap(vals, small, large);
        --large;
      } //if/else
    } //while
    swap(vals, lb, small-1);
    return small-1;
  } // partition(T[], Comparator<? super T>, int, int)

  /**
   * Swap two elements in an array.
   */
  private static <T> void swap(T[] vals, int i, int j) {
    T tmp = vals[i];
    vals[i] = vals[j];
    vals[j] = tmp;
  } // swap(T[], int, int)

  /**
   * Find th median value of three in the array
   */
  private static <T> int median(T[] vals, int left, int right, Comparator<? super T> order){
    int mid = left + (right - left)/2;
    if(order.compare(vals[left], vals[mid]) < 0){
      if(order.compare(vals[mid], vals[right-1]) >= 0){
        return right-1;
      } else {
        return mid;
      }
    } else {
      return left;
    }
  }
} // class ChloeKellySort