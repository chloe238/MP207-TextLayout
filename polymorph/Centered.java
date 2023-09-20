/**
 * A block truncated and centered to a given width
 * 
 * @author Chloe Kelly
 * @version 1.3 of September 19 2023
 */

public class Centered implements TextBlock {
    // FIELDS
    TextBlock block;
    int givenWidth;

    // CONSTRUCTOR
    public Centered(TextBlock block, int givenWidth) {
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
        
        int len = this.block.row(i).trim().length();
        if (len >= this.givenWidth) {
            return this.block.row(i).substring(0, givenWidth);
        } //cut the string down to the specific width 
        else {
            String pad = TBUtils.spaces((givenWidth - len)/2);//get side padding
            return pad + this.block.row(i).trim() + pad;//add whitespace and delete any old space
        } //add spaces to each side
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