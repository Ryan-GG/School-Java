
/**
 * Improved MergeSort class.
 */

public class MergeSortsImproved
{

  public static int THRESHOLD = 16;

  /**
   * Merge sort the provided array using an improved merge operation.
   */
  public static <T extends Comparable<T>> void mergeSort1(T[] items)
  {

    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Comparable[items.length / 2 + 1];
    mergeSort1(items, temp, 0, items.length - 1);

  }

  private static <T extends Comparable<T>> void mergeSort1(T[] items, T[] temp, int left, int right)
  {

    if (left >= right)
    {
      return; // Region has one record
    }

    int mid = (left + right) / 2; // Select midpoint

    mergeSort1(items, temp, left, mid); // Mergesort first half
    mergeSort1(items, temp, mid + 1, right); // Mergesort second half

    mergeImproved(items, temp, left, mid, right);

  }

  /**
   * Efficiently merge two sorted sub-arrays.
   */
  private static <T extends Comparable<T>> void mergeImproved(T[] items, T[] temp, int left,
      int mid, int right)
  {

    int tempPos = 0;
    for (int i = left; i <= mid; i++) {
      temp[tempPos++] = items[i];// Copy subarray to temp
    }
    
    int i1 = 0;
    int i2 = mid + 1;
    
    for (int curr = left; curr <= right; curr++) {
      int endPos = (right - left) / 2 + 1;
      if (i1 == endPos) { // Subarray exhausted
        items[curr] = items[i2++];
      } else if (i2 > right) { // Array exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
      
    }
  }
  

  

  /**
   * Merge sort the provided array by using an improved merge operation AND switching to insertion
   * sort for small sub-arrays.
   */
  public static <T extends Comparable<T>> void mergeSort2(T[] items)
  {

    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Comparable[(items.length + 1) / 2];
    mergeSort2(items, temp, 0, items.length - 1);
  }

  @SuppressWarnings("static-access")
  private static <T extends Comparable<T>> void mergeSort2(T[] items, T[] temp, int left, int right)
  {

    // FINISH THIS!
    // You will need to call the insertion sort method from BasicSorts.java:
    // insertionSort(T[] items, int start, int end)

    if (left >= right)
    {
      return; // Region has one record
    }

    int mid = (left + right) / 2; // Select midpoint

    if ((right - left) < THRESHOLD)
    {
      BasicSorts sorter = new BasicSorts();
      sorter.insertionSort(items,left,right);
    }
    else
    {
      mergeSort2(items, temp, left, mid); // Mergesort first half
      mergeSort2(items, temp, mid + 1, right); // Mergesort second half

      mergeImproved(items, temp, left, mid, right);
    }

  }

}
