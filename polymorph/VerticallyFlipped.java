public class VerticallyFlipped implements TextBlock {

    TextBlock block;

    public VerticallyFlipped(TextBlock block){
        this.block = block;
    }
    /**
     * Get one row from the block.
     * 
     * @pre i < this.height()
     * @exception Exception if the row number is invalid.
     */
    public String row(int i) throws Exception {
        int blockH = this.block.height(); //init our variables
        if ((i < 0) || (i >= blockH)) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid
        return this.block.row(blockH - (i + 1));
    }//row(int)

    /**
     * Determine how many rows are in the block.
     */
    public int height() {
        return this.block.height(); 
    }

    /**
     * Determine how many columns are in the block.
     */
    public int width() {
        return this.block.width();
    }
}
