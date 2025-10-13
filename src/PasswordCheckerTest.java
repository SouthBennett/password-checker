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

  // Test 3: Test to see if isAlphanumeric accept empty strings
@Test  
public void testIsAlphaNumeric_EmptyString() {
  //Arrange 
  PasswordChecker checker = new PasswordChecker(5, 10);
  String password = "";

  //Act
  boolean actual = checker.isAlphanumeric(password);

  //Assert
  assertEquals(false, actual);
}  
  
  //Test for the third public method isBannedPassword: check whether the password is banned, returns true if the password exist in the banned password set

  // Test 1: Test to see if a certain password is banned 
  @Test
  public void testisBannedPassword_NotBanned() {
    //Arrange
    PasswordChecker checker = new PasswordChecker(5, 10);
    String password = "Lebron";

    //Act
    boolean actual = checker.isBannedPassword(password);

    //Assert
    assertEquals(false, actual);
  }

  // Test 2: Test to see if isBannedPassword can catch banned passwords even when the letters are mixed case
  @Test
    public void testIsBannedPassword_IgnoresCase() {
    //Arrange
    PasswordChecker checker = new PasswordChecker(5, 10);
    String password = "pAsSwOrD";
    
    //Act
    boolean actual = checker.isBannedPassword(password);
    
    //Assert
    assertEquals(true, actual);
  }

  //Test 3: Test to check if the isBannedPassword method can conifrm that a password is banned
  @Test
  public void testIsBannedPassword_OnBannedList() {
    //Arrange
    PasswordChecker checker = new PasswordChecker(5, 10);
    String password = "qwerty";

    //Act
    boolean actual = checker.isBannedPassword(password);

    //Assert
    assertEquals(true, actual);
  }
}