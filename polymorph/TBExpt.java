import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky and Chloe Kelly
 * @version 1.3 of September 2023
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void testingTextBlocks(String title, TextBlock[] testBlocks, PrintWriter pen){
    
    pen.println("--- "+ title +" ----");
    TBUtils.print(pen, testBlocks[0]);
    TBUtils.print(pen, testBlocks[1]);
    TBUtils.print(pen, testBlocks[2]);
    pen.println("Three Level Block Width: "+ testBlocks[2].width());
    pen.println("Three Level Block Height: " + testBlocks[2].height());
    pen.println();
  }

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create blocks to use
    TextBlock block = new TextLine("Hello");
    TextBlock blockCopy = new TextLine("Hello");
    TextBlock twoLevel = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock threeLevel = new VComposition(twoLevel, new TextLine("Aloha"));

    TextBlock[] defBlocks = {block, twoLevel, threeLevel};

    // Print out the blocks
    testingTextBlocks("Default Blocks", defBlocks, pen);

    // Truncated [width 4]
    TextBlock[] truncatedBlocks = {new Truncated(block, 4), new Truncated(twoLevel, 4), new Truncated(threeLevel, 4)};
    testingTextBlocks("Truncated to Width 4", truncatedBlocks, pen);

    // Truncated [width 8]
    TextBlock[] truncated2Blocks = {new Truncated(block, 8), new Truncated(twoLevel, 8), new Truncated(threeLevel, 8)};
    testingTextBlocks("Truncated to Width 8", truncated2Blocks, pen);

    // Truncated [width 0]
    TextBlock[] truncated3Blocks = {new Truncated(block, 0), new Truncated(twoLevel, 0), new Truncated(threeLevel, 0)};
    testingTextBlocks("Truncated to Width 8", truncated3Blocks, pen);

    // Centered [width 4]
    TextBlock[] centeredBlocks = {new Centered(block, 4), new Centered(twoLevel, 4), new Centered(threeLevel, 4)};
    testingTextBlocks("Centered to Width 4", centeredBlocks, pen);

    // Centered [width 8]
    TextBlock[] centered2Blocks = {new Centered(block, 8), new Centered(twoLevel, 8), new Centered(threeLevel, 8)};
    testingTextBlocks("Centered to Width 8", centered2Blocks, pen);

    // Centered [width 4]
    TextBlock[] rightBlocks = {new RightJustified(block, 4), new RightJustified(twoLevel, 4), new RightJustified(threeLevel, 4)};
    testingTextBlocks("Right Justified to Width 4", rightBlocks, pen);

    // Centered [width 8]
    TextBlock[] right2Blocks = {new RightJustified(block, 8), new RightJustified(twoLevel, 8), new RightJustified(threeLevel, 8)};
    testingTextBlocks("Right Justified to Width 8", right2Blocks, pen);

    // Horizontally Flipped
    TextBlock[] horizontalBlocks = {new HorizontallyFlipped(block), new HorizontallyFlipped(twoLevel), new HorizontallyFlipped(threeLevel)};
    testingTextBlocks("Horizontally Flipped", horizontalBlocks, pen);

    // Vertically Flipped
    TextBlock[] verticalBlocks = {new VerticallyFlipped(block), new VerticallyFlipped(twoLevel), new VerticallyFlipped(threeLevel)};
    testingTextBlocks("Vertically Flipped", verticalBlocks, pen);

    // Wide Spacing
    TextBlock[] wideBlocks = {new WideSpacing(block), new WideSpacing(twoLevel), new WideSpacing(threeLevel)};
    testingTextBlocks("Wide Space", wideBlocks, pen);

    //Testing Equal Method (Contains the same lines)
    pen.println("--- Equals? True ----");
    pen.println(TBUtils.equal(block, blockCopy) + "\n");
    pen.println("--- Equals? False ----");
    pen.println(TBUtils.equal(block, twoLevel) + "\n");

    //Testing Eqv Method (Built the same way)
    pen.println("--- Eqv? True ----");
    pen.println(TBUtils.eqv(twoLevel, threeLevel) + "\n");
    pen.println("--- Eqv? False ----");
    pen.println(TBUtils.eqv(block, twoLevel) + "\n");

    //Testing Eq Method (Reference the same memory location)
    pen.println("--- Eq? True ----");
    pen.println(TBUtils.eq(block, block) + "\n");
    pen.println("--- Eq? False ----");
    pen.println(TBUtils.eq(block, blockCopy) + "\n");

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
