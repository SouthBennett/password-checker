import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

  @Test
  public void testDescribePasswordLength() {
    PasswordChecker word = new PasswordChecker(5, 6);
    assertEquals(2, 0);
}
