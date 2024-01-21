package team;

/**
 * Represents a view interface for soccer team creation
 * solution: show information and creation states to the user.
 */
public interface TeamView {

  /**
   * Send the new candidate information entered by user to the controller.
   * @param controller the controller of the team creation solution
   */
  void addPlayer(TeamController controller);

  /**
   * Display the new candidate added to the team waiting list.
   * @param newPlayer the name of the new candidate
   */
  void updateCandidateList(String newPlayer);

  /**
   * Send the selected remove player's information to the controller.
   * @param controller the controller of the team creation solution
   */
  void removePlayer(TeamController controller);

  /**
   * Send the message to the controller that the user has clicked the button to create team.
   * @param controller the controller of the team creation solution
   */
  void createTeam(TeamController controller);

  /**
   * Display the created team player list to the user.
   * @param teamList the final soccer team player list
   */
  void showTeamList(String teamList);

  /**
   * Send the message to the controller that the user has clicked the button to
   * select starting lineup.
   * @param controller the controller of the team creation solution
   */
  void selectStartingLineup(TeamController controller);

  /**
   * Display the selected starting lineup player list to the user.
   * @param startingList the selected starting lineup player list
   */
  void showStartingLineup(String startingList);

  /**
   * Display the created team player list to the user again without recreating.
   */
  void reshowTeamList();

  /**
   * Display the selected starting lineup player list to the user again.
   */
  void reshowStartingList();

  /**
   * Display the information entry form to the user with its default value.
   */
  void resetToDefault();

  /**
   * Display the warning to the user when the user makes an invalid operation.
   * @param exception the warning to user when an invalid operation is made
   */
  void showWarning(String exception);
}
