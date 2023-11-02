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

  private static <T> void mergeSort(T[] values, Comparator<? super T> order, int lo, int hi){
    if(hi - lo <= 1){   
      int mid = lo + (hi-lo)/2;
      
      //recursive call for both sides
      mergeSort(values, order, lo, mid);
      mergeSort(values, order, mid, hi);

      //merge
      merge(values, lo, mid, hi, order);
    }
  }

  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    // STUB
    T[] left = Arrays.copyOfRange(vals, lo, mid);
    T[] right = Arrays.copyOfRange(vals, mid, hi);
    int l = 0, r = 0, i = 0; 

    while(l < left.length && r < right.length){  
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

    while(l < left.length){
      vals[i] = left[l];
      i++;
      l++;
    }

    while(r < right.length){
      vals[i] = right[r];
      i++;
      r++;
    }
  } // merge
} // class MergeSort
