package testingGround;

public class merge
{
  
  static int iter = 0;
  static int howmany = 0;
  static boolean toStop = true;
  public static void main(String[] args)
  {

    int[] nums = new int[] {5,8,2,4,7,1,9,3,10,6,15,21,18};

    mergeSort1(nums);

    System.out.println();
    iter = iter + 1;;
    for(int i : nums) {
      System.out.print(i + " ");
    }
    System.out.print("final");
    
   
  }

  public static <T extends Comparable<T>> void mergeSort1(int[] nums) {

    @SuppressWarnings("unchecked")
    int[] temp = new int[nums.length / 2 + 1];
    mergeSort1(nums, temp, 0, nums.length - 1);

  }

  private static <T extends Comparable<T>> void mergeSort1(int[] items, int[] temp, int left,
      int right) {

    if (left >= right) {
      return; // Region has one record
    }

    int mid = (left + right) / 2; // Select midpoint

    mergeSort1(items, temp, left, mid); // Mergesort first half

    
    mergeSort1(items, temp, mid + 1, right); // Mergesort second half

    System.out.println();
    iter++;
    for(int i : items) {
      System.out.print(i + " " );
      
    }
    
    mergeImproved(items, temp, left, mid, right);

    
  }

  /**
   * Efficiently merge two sorted sub-arrays.
   */
  private static <T extends Comparable<T>> void mergeImproved(int[] items, int[] temp, int left,
      int mid, int right) {

    // FINISH THIS!
    //temp is half the array
    //merge to orginial

      
/*
      for (int i = left; i <= right; i++)
      {
        temp[i - left] = items[i];// Copy subarray to temp
      }
*/
    
    for(int i = left; i <= items.length/2; i++) {
      temp[i-left] = items[i];
    }
    
    int i1 = 0;
    int i2 = mid + 1;
    
    
    
    for (int curr = left; curr <= right; curr++) {
      if (i1 == mid + 1) { // Left subarray exhausted
        items[curr] = items[i2++];
      } else if (i2 > right) { // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1] <= (items[i2])) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
    }
    
    
  }

  
    
    
    
    
    
 }
    