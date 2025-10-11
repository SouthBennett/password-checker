import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

  // test for the first public method describePasswordLength: checks whether the password length is within short and medium threshold

  // Test 1: check the length of "hello"
  @Test
  public void testDescribePasswordLength() {
    //arrange
    PasswordChecker word = new PasswordChecker(5, 6);
    //asert
    String actual = word.describePasswordLength("hello");
    //act
    assertEquals("medium", actual);
  }
  // Test 2:

  // Test 3:

  // Test for the second public method isAlphanumeric: checks whether the string has only numbers and string

  // Test 1: basic check, checks "Hello1" 
  @Test
  public void testisAlphanumeric() {
    //arrange
    PasswordChecker word = new PasswordChecker(5, 6);
    //assert
    boolean actual = word.isAlphanumeric("Hello1");
    //act
    assertEquals(true, actual);

  }

  // Test 2: maybe, check if it only has numbers or string.

  // Test 3: maybe check if its empty, or has special characters or stuff.

  public void 
}
