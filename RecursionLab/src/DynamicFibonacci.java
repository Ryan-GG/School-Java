import java.math.BigInteger;
/**
 * 
 * @author Ryan Gross, Seth Walter
 *@version 10/11/20
 */
public class DynamicFibonacci {

  // YOU WILL NEED AN ARRAY HERE FOR LARGE VALUES
  private BigInteger[] store;

  /**
   * Entry point to computing Fib(n). In the dynamic programming version,
   * this method will initialize the memoization table used by the helper
   * method below.
   *
   * @param n The index of the Fibonacci number to compute.
   *
   * @return A BigInteger with the nth Fibonacci number. This data type
   * allows absurdly large calculations like Fib(1000).
   */
  public BigInteger compute(int n) {
    store = new BigInteger[n+1];
    return computeHelper(n);
  }

  /**
   * Recursive Fibonacci calculation helper. Establish the base cases
   * Fib(0) = 0 and Fib(1) = 1, then make necessary recursive calls. For
   * larger values (such as Fib(50) or larger), a dynamic programming
   * memoization table (an array of BigInteger values that stores the
   * smaller results) is necessary.
   *
   * @param n The index of the Fibonacci number to compute. Use Fib(0) = 0
   * and Fib(1) = 1 as the base cases.
   *
   * @return A BigInteger with the nth Fibonacci number. This data type
   * allows absurdly large calculations like Fib(1000).
   */
  public BigInteger computeHelper(int n) {
    BigInteger result;
    if (n <= 1)
    {
      return BigInteger.valueOf(n);
    }
    else 
    {
      if(store[n] == null ) {
        result = computeHelper(n - 1).add(computeHelper(n - 2));
        store[n] = result;
        return result;
      }
    }
  
  return store[n];
  }
}



