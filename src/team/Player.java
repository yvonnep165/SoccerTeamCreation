package team;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

/**
 * This class represents a player of the soccer team.
 */
public class Player {
  private final String firstName;
  private final String lastName;
  private final Integer year;
  private final Integer month;
  private final Integer date;
  private final Position preferredPosition;
  private final Integer skillLevel;
  private Integer jerseyNumber;
  private Position assignedPosition;

  /**
   * Construct a player with the first name, last name, date of birth specified by year, month and
   * date, the preferred position and the assessed skill level. The player's jersey number will be
   * assigned once the team is created. The assigned position will be assigned once selected as
   * starting lineup. Both are default to be null.
   *
   * @param firstName         player's first name
   * @param lastName          player's last name
   * @param year              player's year of birth
   * @param month             player's month of birth
   * @param date              player's date of birth
   * @param preferredPosition player's preferred position (goalie, defender, midfielder, forward)
   * @param skillLevel        a number between 1 and 5 based on the coach's assessment of player's
   *                          skill level
   * @throws IllegalArgumentException if the player's date of birth is invalid, or the player's age
   *                                  is larger than 9 years old or smaller than 1,
   *                                  or the skill level is out of range.
   */
  public Player(String firstName, String lastName, int year, int month, int date,
      Position preferredPosition, int skillLevel) throws IllegalArgumentException {
    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("The name can not be empty");
    }
    if (month < 1 || month > 12 || date < 1 || date > getDaysInMonth(year, month)) {
      throw new IllegalArgumentException("The date of birth is invalid.");
    }
    if (skillLevel > 5 || skillLevel < 1) {
      throw new IllegalArgumentException("The skill level should be from 1 to 5.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.year = year;
    this.month = month;
    this.date = date;
    this.preferredPosition = preferredPosition;
    this.skillLevel = skillLevel;
    this.jerseyNumber = null;
    this.assignedPosition = null;
    int age = getAge();
    if (age > 9 || age < 1) {
      throw new IllegalArgumentException("The player's age is out of limit.");
    }
  }

  /**
   * Helper method to get the day numbers of the player's month of birth.
   *
   * @param year  player's year of birth
   * @param month player's month of birth
   * @return the total day numbers of the player's month of birth
   */
  private int getDaysInMonth(int year, int month) {
    if (month == 2) {
      if (Year.of(year).isLeap()) {
        return 29;
      } else {
        return 28;
      }
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    } else {
      return 31;
    }
  }

  /**
   * Get the first name of the player.
   *
   * @return the first name of the player
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the last name of the player.
   *
   * @return the last name of the player
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the age of the player.
   *
   * @return the age of the player
   */
  public int getAge() {
    LocalDate today = LocalDate.now();
    LocalDate dateOfBirth = LocalDate.of(year, month, date);
    Period age = Period.between(dateOfBirth, today);
    return age.getYears();
  }

  /**
   * Get the preferred position of the player.
   *
   * @return player's preferred position (goalie, defender, midfielder, forward)
   */
  public Position getPreferredPosition() {
    return preferredPosition;
  }

  /**
   * Get the skill level of the player.
   *
   * @return player's skill level, which is a number between 1 and 5 based on the coach's assessment
   *                           (1 = the lowest skill level, 5 = the highest skill level)
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Get the player's jersey number between 1 and 20.
   *
   * @return the player's jersey number
   */
  public int getJerseyNumber() {
    return jerseyNumber;
  }

  /**
   * Set a number for the player's jersey.
   *
   * @param number A jersey number assigned to the player once the team is created
   * @throws IllegalArgumentException if the jersey number is assigned smaller than 1 or larger than
   *                                  20
   * @throws IllegalStateException    if the player has already been assigned a jersey number
   */
  public void setJerseyNumber(int number) throws IllegalArgumentException, IllegalStateException {
    if (number < 1 || number > 20) {
      throw new IllegalArgumentException("Jersey number must be between 1 and 20.");
    }
    if (jerseyNumber != null) {
      throw new IllegalStateException("Jersey number has created and cannot be changed.");
    }
    jerseyNumber = number;
  }

  /**
   * Get the player's assigned position.
   *
   * @return the player's assigned position; if the player is on the bench, the assigned position is
   *                           null.
   */
  public Position getAssignedPosition() {
    return assignedPosition;
  }

  /**
   * Set the player's assigned position.
   *
   * @param position the player's assigned position (goalie, defender, midfielder, forward) when
   *                 selected as the starting lineup.
   */
  public void setAssignedPosition(Position position) {
    assignedPosition = position;
  }

  @Override public String toString() {
    String str = String.format("Player: %s %s; Age: %d; Preferred position: %s; Skill level: %d; ",
        getFirstName(), getLastName(), getAge(), getPreferredPosition().toString(),
        getSkillLevel());
    if (jerseyNumber == null) {
      str = str + "Jersey Number: none; ";
    } else {
      str = str + String.format("Jersey Number: %d; ", getJerseyNumber());
    }
    if (assignedPosition == null) {
      return str + "Assigned position: none";
    } else {
      return str + String.format("Assigned position: %s", getAssignedPosition().toString());
    }
  }
}
