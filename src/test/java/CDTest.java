import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void newCD_instantiatesCorrectly() {
    CD testCD = new CD("Artist", "Title");
    assertEquals(true, testCD instanceof CD);
  }

  @Test
  public void getArtist_returnsMArtist_String() {
    CD testCD = new CD("Artist", "Title");
    String expectedOutput = "Artist";
    assertEquals(expectedOutput, testCD.getArtist());
  }

  @Test
  public void getTitle_returnsMTitle_String() {
    CD testCD = new CD("Artist", "Title");
    String expectedOutput = "Title";
    assertEquals(expectedOutput, testCD.getTitle());
  }
}
