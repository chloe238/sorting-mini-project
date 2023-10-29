import java.util.Comparator;
import java.util.Arrays;

/**
 * Sort using merge sort.
 *
 * @author Chloe Kelly
 * @author Christina Vu
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeSort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  static <T> void mergeSort(T[] values, Comparator<? super T> order, int lo, int hi){
    if(values.length < 2){
      return;
    }   
    int mid = lo + (hi-lo)/2;
    T[] left = Arrays.copyOfRange(values, lo, mid);
    T[] right = Arrays.copyOfRange(values, mid+1, hi);
    
    mergeSort(left, order, 0, left.length);
    mergeSort(right, order, 0, right.length);
    merge(values, lo, mid, hi, order);
  }

  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    // STUB
    T[] left = Arrays.copyOfRange(vals, lo, mid);
    T[] right = Arrays.copyOfRange(vals, mid+1, hi);
    int l = 0, r = 0, i = 0; 
    while(l < left.length-1 || r < right.length-1){  
      if(comparator.compare(left[l], right[r]) <= 0){
        vals[i] = left[l];
        l++;
      }
      else {
        vals[i] = right[r];
        r++;
      }
      i++;
    }
  } // merge
} // class MergeSort
