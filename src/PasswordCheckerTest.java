import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
  // Test 2: testing a long string
  @Test
  public void testDescribePasswordLengthLong() {
    //arrange
    PasswordChecker word = new PasswordChecker(5, 6);
    //asert
    String actual = word.describePasswordLength("hello123123123123123123123123123123123123123123");
    //act
    assertEquals("long", actual);
  }

  // Test 3: testing an empty string
  @Test
  public void testDescribePasswordLengthShort() {
    //arrange
    PasswordChecker word = new PasswordChecker(1, 2);
    //asert
    String actual = word.describePasswordLength("");
    //act
    assertEquals("short", actual);
  }

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

  //Test for the third public method isBannedPassword: check whether the password is banned, returns true if the password exist in the banned password set
  // Test 1: basic check, checks whether "password123" exist. 
  @Test
  public void testisBannedPassword() {

    // this part right here, the string lebron is not being added, i dont understand why.?????
    Set<String> banned = new HashSet<>(Arrays.asList("Lebron"));
    PasswordChecker word = new PasswordChecker(5, 6, banned);

    boolean actual = word.isBannedPassword("Lebron");

    assertEquals(true, actual);
  }
  // Test 2: maybe add a list of random strings and check if returning one of them is true

  // Test 3: maybe check if its empty, or has special characters or stuff.
}
