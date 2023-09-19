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
    public String row(int i) throws Exception{
        // get current height
        int initHeight = this.block.height();
        String insert =  "";

        if (this.block.width() > givenWidth) {
            initHeight++;
            insert = this.block.row(i).substring(givenWidth);
            
        }

        if ((i < 0) || (i >= initHeight)) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid
        else if(this.block.width() > givenWidth){
            while(this.block.width() > givenWidth){
                return this.block.row(i).substring(0, givenWidth);
            }
        }
    }

    public int height() {

        return 0;
    }

    public int width() {
        if (this.block.width() < this.givenWidth) {
            return this.block.width();
        } else {
            return this.givenWidth;
        }
    }
}