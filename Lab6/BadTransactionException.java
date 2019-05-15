/* BadTransactionException.java */

/**
 *  Implements an exception that should be thrown for invalid withdraw and deposit.
 **/
public class BadTransactionException extends Exception {

  public int amount;  // The invalid amount.

  /**
   *  Creates an exception object for invalid amount of withdraw or deposit.
   **/
  public BadTransactionException(int badAmount) {
    super("Invalid amount: " + badAmount);

    //amount = badAmount;
  }
}
