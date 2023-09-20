/**
 * A block with it's row content spacing increased
 * 
 * @author Chloe Kelly
 * @version 1.3 of September 19 2023
 */

public class WideSpacing implements TextBlock{
    
    TextBlock block;

    public WideSpacing(TextBlock block){
        this.block = block;
    }//WideSpacing(TextBlock)

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

        int rowWidth = this.block.row(i).length();; //init our variables
        String spaceCopy = "";
        
        for(int a = 0; a < rowWidth; a++){ //adding space after every character
            spaceCopy = spaceCopy + this.block.row(i).charAt(a) + " ";
        }//for
        return spaceCopy;
    }//row(int)

    /**
     * Determine how many rows are in the block.
     */
    public int height() {
        return this.block.height(); 
    }//height()

    /**
     * Determine how many columns are in the block.
     */
    public int width() {
        return this.block.width() * 2;
    }//width()
}
