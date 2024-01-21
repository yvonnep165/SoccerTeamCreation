package team;

import java.util.List;

/**
 * This interface represents the operations offered by the Soccer Team
 * Model to build the soccer team.
 */
public interface SoccerTeamModel {

  /**
   * Add the player to the soccer team waiting player list.
   * @param player the player to be added into the team waiting list
   * @throws IllegalStateException if the soccer team has been formed
   */
  void addPlayer(Player player) throws IllegalStateException;

  /**
   * Remove the player from the soccer team waiting player list.
   * @param player the player to be removed from the team waiting list
   * @throws IllegalStateException if the soccer team has been formed
   * @throws IllegalArgumentException if the player is not in the team waiting list
   */
  void removePlayer(Player player) throws IllegalStateException, IllegalArgumentException;

  /**
   * Get the size of the soccer team or the player waiting list.
   * @return the size of the soccer team or the player waiting list
   */
  int getPlayerListSize();

  /**
   * Build the soccer team and if the team has more than 20 players, ths ones
   * with the lowest skill level will be ignored.
   * @throws IllegalStateException if the team doesn't have a minimum of 10
   *                players
   */
  void createSoccerTeam() throws IllegalStateException;

  /**
   * Get the list of the players in the soccer team or in the player waiting list.
   * @return the list of the players in the soccer team or in the player waiting list.
   */
  List<Player> getPlayerList();

  /**
   * Select the starting lineup, which is the group of seven players who will
   * start each game. The remaining players in the team are on the bench.
   * @throws IllegalStateException if the soccer team has not been built.
   */
  void selectStartingLineUp() throws IllegalStateException;

  /**
   * Get the list of the players in the Starting lineup.
   * @return list of the players in the Starting lineup
   */
  List<Player> getStartingLineUp();

  /**
   * To get a String with a list of all the players in the team.
   * The following information is provided for every player: first name, last name, jersey number.
   * @return a String with a list of all the players in the team
   * @throws IllegalStateException if the soccer team has not been built.
   */
  String showListOfTeamPlayer() throws IllegalStateException;

  /**
   * To get a String with a list of the starting lineup: The following information is provided for
   * every player: first name, last name, jersey number, and position.
   * @return a String with a list of the starting lineup
   * @throws IllegalStateException if the Starting lineup has not been selected.
   */
  String showStartingLineUp() throws IllegalStateException;
}
