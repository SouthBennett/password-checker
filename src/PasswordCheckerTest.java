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

  // Test 2: test to see if isAlphanumerc will accept symbols
  // Test works but if the string is "Hello1" the test still passes
  // its gotta be the method thats causing this but i cant figure it out
  @Test
public void testIsAlphanumeric_FailWithSymbol() {
    //Arrange
    PasswordChecker checker = new PasswordChecker(5, 10);
    String password = "Hello@";

    //Act
    boolean actual = checker.isAlphanumeric(password);

    //Assert
    assertEquals(false, actual);
}

  // Test 3: maybe check if its empty, or has special characters or stuff.
@Test  
public void testIsAlphaNumeric_EmptyString() {
  PasswordChecker checker = new PasswordChecker(5, 10);
  String password = "";

  boolean actual = checker.isAlphanumeric(password);

  assertEquals(true, actual);
}  
  
  //Test for the third public method isBannedPassword: check whether the password is banned, returns true if the password exist in the banned password set
  // Test 1: basic check, checks whether "password123" exist. 
  @Test
  public void testisBannedPassword() {
    //FIXED: lebron passing in argument needs to be all lower case
    Set<String> banned = new HashSet<>(Arrays.asList("Lebron".toLowerCase(), "Lebron1".toLowerCase()));
    // this part right here, the string lebron is not being added, i dont understand why.?????
    PasswordChecker word = new PasswordChecker(5, 6, banned);

    boolean actual = word.isBannedPassword("Lebron1");

    assertEquals(true, actual);
  }

  //
}
