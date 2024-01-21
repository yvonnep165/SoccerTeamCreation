package team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * This class represents a Soccer Team building model implementation. If offers all the operations
 * mandated by the SoccerTeamModel interface.
 */
public class SoccerTeamModelImp implements SoccerTeamModel {
  private final List<Player> playerList = new ArrayList<>();
  private final List<Player> startingLineUp = new ArrayList<>();
  private boolean formedTeam = false;

  /**
   * Construct a Soccer Team with no player in the list. And the team has not been officially
   * built.
   */
  public SoccerTeamModelImp() {
  }

  @Override public void addPlayer(Player player) throws IllegalStateException {
    if (formedTeam) {
      throw new IllegalStateException("The team has been built.");
    }
    playerList.add(player);
  }

  @Override public void removePlayer(Player player)
      throws IllegalStateException, IllegalArgumentException {
    if (formedTeam) {
      throw new IllegalStateException("The team has been built.");
    }
    if (playerList.contains(player)) {
      playerList.remove(player);
    } else {
      throw new IllegalArgumentException("The player is not in the player list.");
    }
  }

  @Override public int getPlayerListSize() {
    return playerList.size();
  }

  @Override public void createSoccerTeam() throws IllegalStateException {
    if (getPlayerListSize() < 10) {
      throw new IllegalStateException(
          "The team cannot be created unless more players are added.");
    }
    // sorted by skill level first then by last name alphabetically
    // prepared for Starting line up selection
    Collections.sort((playerList), new Comparator<>() {
      @Override public int compare(Player o1, Player o2) {
        int skillCompare = Integer.compare(o2.getSkillLevel(), o1.getSkillLevel());
        if (skillCompare != 0) {
          return skillCompare;
        }
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
      }
    });
    while (playerList.size() > 20) {
      playerList.remove(playerList.size() - 1);
    }
    assignJerseyNumber();
    formedTeam = true;
  }

  /**
   * Helper method to assign Jersey Number. Each player in the team gets a unique number of their
   * jersey between 1 and 20 randomly.
   */
  private void assignJerseyNumber() {
    List<Integer> numbersOption = new ArrayList<>();
    Random random = new Random();
    for (int i = 1; i <= 20; i++) {
      numbersOption.add(i);
    }
    for (int j = 0; j < getPlayerListSize(); j++) {
      int index = random.nextInt(numbersOption.size());
      int jerseyNumber = numbersOption.get(index);
      playerList.get(j).setJerseyNumber(jerseyNumber);
      numbersOption.remove(index);
    }
  }

  @Override public List<Player> getPlayerList() {
    return playerList;
  }

  @Override public void selectStartingLineUp() throws IllegalStateException {
    if (!formedTeam) {
      throw new IllegalStateException(
          "Starting line up can not be selected before the team is built.");
    }
    for (int i = 0; i < 7; i++) {
      startingLineUp.add(playerList.get(i));
    }
    assignPosition();
    Collections.sort(startingLineUp, new Comparator<>() {
      @Override public int compare(Player o1, Player o2) {
        int positionCompare = Integer.compare(o1.getAssignedPosition().ordinal(),
            o2.getAssignedPosition().ordinal());
        if (positionCompare != 0) {
          return positionCompare;
        }
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
      }
    });
  }

  /**
   * Helper method to assign position to the group of seven players who will start each game.
   */
  private void assignPosition() {
    List<Position> positionOption = new ArrayList<>();
    positionOption.add(Position.GOALIE);
    for (int i = 0; i < 2; i++) {
      positionOption.add(Position.DEFENDER);
    }
    for (int j = 0; j < 3; j++) {
      positionOption.add(Position.MIDFIELDER);
    }
    positionOption.add(Position.FORWARD);
    // If available, players will be assigned their preferred positions
    for (Player value : startingLineUp) {
      Position preferredPosition = value.getPreferredPosition();
      if (positionOption.contains(preferredPosition)) {
        value.setAssignedPosition(preferredPosition);
        positionOption.remove(preferredPosition);
      }
    }
    // the players didn't get their preferred positions will be assigned the rest positions
    for (Player player : startingLineUp) {
      if (player.getAssignedPosition() == null) {
        player.setAssignedPosition(positionOption.get(0));
        positionOption.remove(0);
      }
    }
  }

  @Override public List<Player> getStartingLineUp() {
    return startingLineUp;
  }

  @Override public String showListOfTeamPlayer() throws IllegalStateException {
    if (!formedTeam) {
      throw new IllegalStateException("The team has not been built");
    }
    List<Player> copy = new ArrayList<>();
    for (int i = 0; i < getPlayerListSize(); i++) {
      copy.add(playerList.get(i));
    }
    // The list is sorted in alphabetical order of last name for display.
    Collections.sort(copy, new Comparator<>() {
      @Override public int compare(Player o1, Player o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
      }
    });
    String str = "";
    for (Player player : copy) {
      str += String.format("Last Name: %s ; First Name: %s; Jersey Number: %d\n",
          player.getLastName(), player.getFirstName(), player.getJerseyNumber());
    }
    return str;
  }

  @Override public String showStartingLineUp() throws IllegalStateException {
    if (getStartingLineUp().isEmpty()) {
      throw new IllegalStateException("The starting lineup has not been selected.");
    }
    String str = "";
    for (Player player : startingLineUp) {
      str += String.format("%s - Last Name: %s; First Name: %s; Jersey Number: %d\n",
          player.getAssignedPosition().toString(), player.getLastName(), player.getFirstName(),
          player.getJerseyNumber());
    }
    return str;
  }
}
