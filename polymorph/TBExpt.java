import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");
    TextBlock twoLevel = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock threeLevel = new VComposition(twoLevel, new TextLine("Aloha"));

    // Print out the block
    pen.println("--- Default Blocks ----");
    TBUtils.print(pen, block);
    TBUtils.print(pen, twoLevel);
    TBUtils.print(pen, threeLevel);

    // Horizontally Flipped
    pen.println("--- Horizontally Flipped Tests ----");
    TBUtils.print(pen, new HorizontallyFlipped(block));
    TBUtils.print(pen, new HorizontallyFlipped(twoLevel));
    TBUtils.print(pen, new HorizontallyFlipped(threeLevel));

    // Vertically Flipped
    pen.println("--- Vertically Flipped Tests ----");
    TBUtils.print(pen, new VerticallyFlipped(block));
    TBUtils.print(pen, new VerticallyFlipped(twoLevel));
    TBUtils.print(pen, new VerticallyFlipped(threeLevel));

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
