import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
    pen.println(); //adding this to make blocks easier to see while testing
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * Compares two TextBlocks to see if their contents are the same
   */
  public static boolean equal(TextBlock t1, TextBlock t2){
    for (int i = 0; i < t1.height() || i < t2.height(); i++) {
      try {
        if(t1.row(i).compareTo(t2.row(i)) != 0){
          return false;
        }
      } catch (Exception e) {
        return false;
      } // catch (Exception)
    }
    return true;
  }//equal(TextBlock, TextBlock)

  /**
   * Compares two TextBlocks to see if they were built the same way
   * 
   */
  public static boolean eqv(TextBlock t1, TextBlock t2){
    return (t1.getClass() == t2.getClass());
  }//eqv(TextBlock, TextBlock)
  
  /**
   * Compares two TextBlocks to see if they share the same space in memory
   */
  public static boolean eq(TextBlock t1, TextBlock t2){
    return (t1 == t2);
  }//eq(TextBlock, TextBlock)
} // class TBUtils
