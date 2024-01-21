import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import team.Player;
import team.Position;

/**
 * Test cases for the Player class. Verify that the player information is properly stored, and all
 * action are properly validated.
 */
public class PlayerTest {
  private Player player1;
  private Player player2;

  /**
   * Setting up some objects of type Player.
   */
  @Before public void setup() {
    player1 = new Player("Harry", "Potter", 2013, 10, 8, Position.GOALIE, 5);
    player2 = new Player("Hermione", "Granger", 2014, 5, 13, Position.MIDFIELDER, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFirstNameEmpty() {
    new Player("", "Potter", 2013, 10, 8, Position.GOALIE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLastNameEmpty() {
    new Player("Harry", "", 2013, 10, 8, Position.GOALIE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSmallerThanJanMonthOfBirth() {
    new Player("Ron", "Weasley", 2015, 0, 10, Position.DEFENDER, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLargerThanDecMonthOfBirth() {
    new Player("Luna", "Lovegood", 2014, 13, 1, Position.MIDFIELDER, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSmallerThanOneDateOfBirth() {
    new Player("Harry", "Potter", 2013, 10, 0, Position.GOALIE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLargerThanDaysInFebNotLeap() {
    new Player("Harry", "Potter", 2015, 2, 29, Position.GOALIE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLargerThanDaysInFebLeapYear() {
    new Player("Harry", "Potter", 2016, 2, 30, Position.GOALIE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLargerThanDaysInShorterMonth() {
    new Player("Harry", "Potter", 2016, 6, 31, Position.GOALIE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLargerThanDaysInLongerMonth() {
    new Player("Harry", "Potter", 2016, 3, 32, Position.GOALIE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAgeLargerThanNine() {
    new Player("Hermione", "Granger", 2013, 4, 1, Position.MIDFIELDER, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAgeSmallerThanOne() {
    new Player("Hermione", "Granger", 2022, 5, 1, Position.MIDFIELDER, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSkillLevelSmallerThanOne() {
    new Player("Hermione", "Granger", 2014, 5, 13, Position.MIDFIELDER, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSkillLevelSmallerThanFive() {
    new Player("Hermione", "Granger", 2014, 5, 13, Position.MIDFIELDER, 6);
  }

  @Test
  public void testGetFirstName() {
    assertEquals("Harry", player1.getFirstName());
    assertEquals("Hermione", player2.getFirstName());
  }

  @Test
  public void testGetLastName() {
    assertEquals("Potter", player1.getLastName());
    assertEquals("Granger", player2.getLastName());
  }

  @Test
  public void testGetAge() {
    assertEquals(9, player1.getAge());
    assertEquals(8, player2.getAge());
  }

  @Test
  public void testGetPreferredPosition() {
    assertEquals(Position.GOALIE, player1.getPreferredPosition());
    assertEquals(Position.MIDFIELDER, player2.getPreferredPosition());
  }

  @Test
  public void testGetSkillLevel() {
    assertEquals(5, player1.getSkillLevel());
    assertEquals(3, player2.getSkillLevel());
  }

  @Test
  public void testJerseyNumber() {
    player1.setJerseyNumber(4);
    player2.setJerseyNumber(18);
    assertEquals(4, player1.getJerseyNumber());
    assertEquals(18, player2.getJerseyNumber());
  }

  @Test(expected = IllegalStateException.class)
  public void testReassignJerseyNumber() {
    player1.setJerseyNumber(4);
    player1.setJerseyNumber(5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSmallerThanOneJerseyNumber() {
    player1.setJerseyNumber(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLargerThanTwentyJerseyNumber() {
    player1.setJerseyNumber(21);
  }

  @Test
  public void testAssignedPosition() {
    player1.setAssignedPosition(Position.DEFENDER);
    player2.setAssignedPosition(Position.FORWARD);
    assertEquals(Position.DEFENDER, player1.getAssignedPosition());
    assertEquals(Position.FORWARD, player2.getAssignedPosition());
    player1.setAssignedPosition(Position.MIDFIELDER);
    assertEquals(Position.MIDFIELDER, player1.getAssignedPosition());
  }

  @Test
  public void testToString() {
    assertEquals("Player: Harry Potter; Age: 9; Preferred "
            + "position: GOALIE; Skill level: 5; Jersey Number: none; " + "Assigned position: none",
        player1.toString());
    player2.setJerseyNumber(5);
    player2.setAssignedPosition(Position.FORWARD);
    assertEquals("Player: Hermione Granger; Age: 8; Preferred "
            + "position: MIDFIELDER; Skill level: 3; Jersey Number: 5; "
            + "Assigned position: FORWARD",
        player2.toString());
  }
}