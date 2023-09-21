/**
 * A block truncated to a given width
 * 
 * @author Chloe Kelly
 * @version 1.3 of September 19 2023
 */

public class Truncated implements TextBlock {
  // FIELDS
  TextBlock block;
  int givenWidth;

  // CONSTRUCTOR
  public Truncated(TextBlock block, int givenWidth) {
    this.block = block;
    this.givenWidth = givenWidth;
  }

  // METHODS *
  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.block.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    int len = this.block.row(i).length();
    if (len >= this.givenWidth) {
      return this.block.row(i).substring(0, givenWidth);
    } // cut the string down to the specific width
    else {
      String pad = TBUtils.spaces(givenWidth - len);// get left padding
      return this.block.row(i) + pad;
    } // no change needed if the row is already less than the width
  }// row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.block.height();
  }// height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.givenWidth;
  }// width()
}