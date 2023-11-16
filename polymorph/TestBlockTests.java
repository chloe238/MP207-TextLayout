import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky and Chloe Kelly
 * @version 1.3 of September 2023
 */
public class TestBlockTests {
  static TextBlock block = new TextLine("Hello");
  static TextBlock twoLevel = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
  static TextBlock threeLevel = new VComposition(twoLevel, new TextLine("Aloha"));
  static TextBlock boxed = new BoxedBlock(new VComposition(twoLevel, new TextLine("Aloha")));
  
  //----Truncated Tests----
  @Test
  public void singleLineSmallWidth(){
    TextBlock blockTruncated = new Truncated(block, 4);
    assertTrue(TBUtils.equal(new TextLine("Hell"), blockTruncated));
  }//singleLineSmallWidth()

  @Test
  public void singleLineLargeWidth(){
    TextBlock blockTruncated = new Truncated(block, 9);
    assertTrue(TBUtils.equal(new TextLine("Hello    "), blockTruncated));
  }//singleLineLargeWidth()

  @Test
  public void doubleLineSmallWidth(){
    TextBlock blockTruncated = new Truncated(twoLevel, 4);
    assertTrue(TBUtils.equal(new VComposition(new TextLine("Hell"), new TextLine("Good")), blockTruncated));
  }//doubleLineSmallWidth()

  @Test
  public void tripleLineSmallWidth(){
    TextBlock blockTruncated = new Truncated(threeLevel, 4);
    assertTrue(TBUtils.equal(new VComposition(new VComposition(new TextLine("Hell"), new TextLine("Good")), new TextLine("Aloh")), blockTruncated));
  }//tripleLineSmallWidth()

  @Test
  public void emptyBlock(){
    TextBlock blockTruncated = new Truncated(new TextLine(""), 4);
    assertTrue(TBUtils.equal(new TextLine("    "), blockTruncated));
  }//emptyBlock()

  @Test
  public void zeroWidth(){
    TextBlock blockTruncated = new Truncated(block, 0);
    assertTrue(TBUtils.equal(new TextLine(""), blockTruncated));
  }//zeroWidth()

  //----Centered Tests----
  @Test
  public void singleLineSmallWidthC(){
    TextBlock blockCentered = new Centered(block, 4);
    assertTrue(TBUtils.equal(new TextLine("Hell"), blockCentered));
  }//singleLineSmallWidthC()

  @Test
  public void singleLineLargeWidthC(){
    TextBlock blockCentered = new Centered(block, 9);
    assertTrue(TBUtils.equal(new TextLine("  Hello  "), blockCentered));
  }//singleLineLargeWidthC()

  @Test
  public void doubleLineLargeWidthC(){
    TextBlock blockCentered = new Centered(twoLevel, 9);
    assertTrue(TBUtils.equal(new VComposition(new TextLine("  Hello  "), new TextLine(" Goodbye ")), blockCentered));
  }//doubleLineLargeWidthC()

  @Test
  public void tripleLineLargeWidthC(){
    TextBlock blockCentered = new Centered(threeLevel, 9);
    assertTrue(TBUtils.equal(new VComposition(new VComposition(new TextLine("  Hello  "), new TextLine(" Goodbye ")), new TextLine("  Aloha  ")), blockCentered));
  }//tripleLineLargeWidthC()

  @Test
  public void emptyBlockC(){
    TextBlock blockCentered = new Centered(new TextLine(""), 4);
    assertTrue(TBUtils.equal(new TextLine("    "), blockCentered));
  }//emptyBlockC()

  @Test
  public void zeroWidthC(){
    TextBlock blockCentered = new Centered(block, 0);
    assertTrue(TBUtils.equal(new TextLine(""), blockCentered));
  }//zeroWidthC()

  //----Right Justified Tests----
  @Test
  public void singleLineSmallWidthR(){
    TextBlock blockRightJustified = new RightJustified(block, 4);
    assertTrue(TBUtils.equal(new TextLine("Hell"), blockRightJustified));
  }//singleLineSmallWidthR()

  @Test
  public void singleLineLargeWidthR(){
    TextBlock blockRightJustified = new RightJustified(block, 9);
    assertTrue(TBUtils.equal(new TextLine("    Hello"), blockRightJustified));
  }//singleLineLargeWidthR()

  @Test
  public void doubleLineLargeWidthR(){
    TextBlock blockRightJustified = new RightJustified(twoLevel, 9);
    assertTrue(TBUtils.equal(new VComposition(new TextLine("    Hello"), new TextLine("  Goodbye")), blockRightJustified));
  }//doubleLineLargeWidthR()

  @Test
  public void tripleLineLargeWidthR(){
    TextBlock blockRightJustified = new RightJustified(threeLevel, 9);
    assertTrue(TBUtils.equal(new VComposition(new VComposition(new TextLine("    Hello"), new TextLine("  Goodbye")), new TextLine("    Aloha")), blockRightJustified));
  }//tripleLineLargeWidthR

  @Test
  public void emptyBlockR(){
    TextBlock blockRightJustified = new RightJustified(new TextLine(""), 4);
    assertTrue(TBUtils.equal(new TextLine("    "), blockRightJustified));
  }//emptyBlockR()

  @Test
  public void zeroWidthR(){
    TextBlock blockRightJustified = new RightJustified(block, 0);
    assertTrue(TBUtils.equal(new TextLine(""), blockRightJustified));
  }//zeroWidthR()

  //----Flips----
  @Test
  public void horizonFlipThreeLevel(){
    TextBlock blockHFlipped = new HorizontallyFlipped(threeLevel);
    assertTrue(TBUtils.equal(new VComposition(new VComposition(new TextLine("  olleH"), new TextLine("eybdooG")), new TextLine("  aholA")), blockHFlipped));
  }//horizonFlipThreeLevel()

  @Test
  public void vertFlipThreeLevel(){
    TextBlock blockVFlipped = new VerticallyFlipped(threeLevel);
    assertTrue(TBUtils.equal(new VComposition(new VComposition(new TextLine("Aloha"), new TextLine("Goodbye")), new TextLine("Hello")), blockVFlipped));
  }//vertFlipThreeLevel()

  @Test
  public void horizonFlipEmpty(){
    TextBlock blockHFlipped = new HorizontallyFlipped(new TextLine(""));
    assertTrue(TBUtils.equal(new TextLine(""), blockHFlipped));
  }//horizonFlipEmpty()

  @Test
  public void vertFlipEmpty(){
    TextBlock blockVFlipped = new VerticallyFlipped(new TextLine(""));
    assertTrue(TBUtils.equal(new TextLine(""), blockVFlipped));
  } //vertFlipEmpty()
} // class TestBlockTests
