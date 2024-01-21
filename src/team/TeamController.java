package team;

/**
 * Represent a Controller interface for the soccer team creation solution: handle user
 * information by executing them using the model;
 * convey soccer team player information to the user in the view.
 */
public interface TeamController {

  /**
   * Execute one round of interactive soccer team creation.
   */
  void startCreateTeam();

  /**
   * Tell the model to add a new player to the candidate list.
   * And let the view show the new player.
   * @param firstName player's first name
   * @param lastName player's last name
   * @param year player's year of birth
   * @param month player's month of birth
   * @param date player's date of birth
   * @param preferredPosition player's preferred position
   * @param skillLevel player's skill level based on the coach's assessment
   */
  void addCandidate(String firstName, String lastName, int year, int month, int date,
      Position preferredPosition, int skillLevel);

  /**
   * Tell the model to remove a player with specific index in the candidate list.
   * @param index the index of the player in the candidate list
   */
  void removeCandidate(int index);

  /**
   * Tell the model to create the official soccer team.
   * And let the view show the players list of the soccer team
   */
  void createTeam();

  /**
   * Tell the model to select the starting lineup.
   * And let the view show the players list of the starting lineup
   */
  void createStartingLineup();
}
