/**
 * A text block whose row contents are reversed
 * 
 * @author Chloe Kelly
 * @version 1.3 of September 19 2023
 */

public class HorizontallyFlipped implements TextBlock {

  TextBlock block;

  public HorizontallyFlipped(TextBlock block) {
    this.block = block;
  }

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.block.height())) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    int rowWidth = this.block.row(i).length();
    ; // init our variables
    String reverseCopy = "";

    for (int a = rowWidth - 1; a >= 0; a--) { // reverse loop
      reverseCopy = reverseCopy + this.block.row(i).charAt(a);
    } // for
    return reverseCopy;
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
    return this.block.width();
  }// width()
}// HorizontallyFlipped(Textblock)
