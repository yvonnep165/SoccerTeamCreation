import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import team.Player;
import team.Position;
import team.SoccerTeamModel;
import team.SoccerTeamModelImp;

/**
 * Test cases for the SoccerTeamModelImp class. Verify that the team is properly created and all
 * action are properly validated.
 */
public class SoccerTeamModelImpTest {
  private SoccerTeamModel soccerTeam = new SoccerTeamModelImp();

  @Test
  public void testAddPlayer() {
    assertEquals(0, soccerTeam.getPlayerListSize());
    List<Player> players = playerListHelper();
    for (int i = 0; i < 3; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    assertEquals(3, soccerTeam.getPlayerListSize());
    for (int i = 0; i < 3; i++) {
      assertEquals(players.get(i).toString(), soccerTeam.getPlayerList().get(i).toString());
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testAddPlayerAfterTeamCreated() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 10; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    soccerTeam.addPlayer(players.get(10));
  }

  @Test
  public void testRemovePlayer() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 3; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.removePlayer(players.get(0));
    assertEquals(2, soccerTeam.getPlayerListSize());
    assertEquals(players.get(1).toString(), soccerTeam.getPlayerList().get(0).toString());
    assertEquals(players.get(2).toString(), soccerTeam.getPlayerList().get(1).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNotContainPlayer() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 3; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.removePlayer(players.get(4));
  }

  @Test(expected = IllegalStateException.class)
  public void testRemovePlayerAfterTeamCreated() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 10; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    soccerTeam.removePlayer(players.get(0));
  }

  @Test(expected = IllegalStateException.class)
  public void testCreateTeamWithLessThanTenPeople() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 9; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
  }

  @Test
  public void testCreateTeamWithTenPeople() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 10; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    assertEquals(10, soccerTeam.getPlayerListSize());
    // check sorted by skill level first then by last name alphabetically
    // The order prepared for Starting line up selection
    assertEquals(players.get(1).toString(), soccerTeam.getPlayerList().get(0).toString());
    assertEquals(players.get(0).toString(), soccerTeam.getPlayerList().get(1).toString());
    assertEquals(players.get(5).toString(), soccerTeam.getPlayerList().get(5).toString());
    assertEquals(players.get(7).toString(), soccerTeam.getPlayerList().get(8).toString());
    assertEquals(players.get(8).toString(), soccerTeam.getPlayerList().get(9).toString());
  }

  @Test
  public void testCreateTeamWithMoreThanTwentyPeople() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 22; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    assertEquals(20, soccerTeam.getPlayerListSize());
    assertEquals(players.get(10).toString(), soccerTeam.getPlayerList().get(0).toString());
    assertEquals(players.get(7).toString(), soccerTeam.getPlayerList().get(18).toString());
    assertEquals(players.get(21).toString(), soccerTeam.getPlayerList().get(19).toString());
  }

  @Test
  public void testGetPlayerListBeforeCreateTeam() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 11; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    // check the first two players in the list
    assertEquals(11, soccerTeam.getPlayerListSize());
    assertEquals(players.get(0).toString(), soccerTeam.getPlayerList().get(0).toString());
    assertEquals(players.get(1).toString(), soccerTeam.getPlayerList().get(1).toString());
  }

  @Test
  public void testGetPlayerListAfterCreateTeam() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 11; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    assertEquals(11, soccerTeam.getPlayerListSize());
    // check the first two players in the list
    assertEquals(players.get(10).toString(), soccerTeam.getPlayerList().get(0).toString());
    assertEquals(players.get(1).toString(), soccerTeam.getPlayerList().get(1).toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testSelectStartingLineUpBeforeTeam() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 10; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.selectStartingLineUp();
  }

  @Test
  public void testSelectStartingLineUp() {
    List<Player> players = playerListHelper();
    for (int i = 10; i < 20; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    assertEquals(10, soccerTeam.getPlayerListSize());
    soccerTeam.selectStartingLineUp();
    assertEquals(players.get(12).toString(), soccerTeam.getStartingLineUp().get(0).toString());
    assertEquals(players.get(18).toString(), soccerTeam.getStartingLineUp().get(1).toString());
    assertEquals(players.get(17).toString(), soccerTeam.getStartingLineUp().get(2).toString());
    assertEquals(players.get(10).toString(), soccerTeam.getStartingLineUp().get(3).toString());
    assertEquals(players.get(19).toString(), soccerTeam.getStartingLineUp().get(4).toString());
    assertEquals(players.get(16).toString(), soccerTeam.getStartingLineUp().get(5).toString());
    assertEquals(players.get(13).toString(), soccerTeam.getStartingLineUp().get(6).toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testShowListOfTeamPlayerBeforeTeam() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 10; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.showListOfTeamPlayer();
  }

  @Test
  public void testShowListOfTeamPlayer() {
    List<Player> players = playerListHelper();
    for (int i = 10; i < 20; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    assertEquals(10, soccerTeam.getPlayerListSize());
    String[] playerInfo = soccerTeam.showListOfTeamPlayer().split("\n");
    assertEquals("Last Name: Black ; First Name: Sirius; Jersey Number: ",
        playerInfo[0].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Chang ; First Name: Cho; Jersey Number: ",
        playerInfo[1].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Delacour ; First Name: Fleur; Jersey Number: ",
        playerInfo[2].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Greengrass ; First Name: Astoria; Jersey Number: ",
        playerInfo[3].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Longbottom ; First Name: Neville; Jersey Number: ",
        playerInfo[4].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Lupin ; First Name: Remus; Jersey Number: ",
        playerInfo[5].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Parkinson ; First Name: Pansy; Jersey Number: ",
        playerInfo[6].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Pettigrew ; First Name: Peter; Jersey Number: ",
        playerInfo[7].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Scamander ; First Name: Newt; Jersey Number: ",
        playerInfo[8].replaceAll("[0-9]", ""));
    assertEquals("Last Name: Tonks ; First Name: Nymphadora; Jersey Number: ",
        playerInfo[9].replaceAll("[0-9]", ""));
  }

  @Test(expected = IllegalStateException.class)
  public void testShowStartingLineUpBeforeTeam() {
    List<Player> players = playerListHelper();
    for (int i = 0; i < 10; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.showStartingLineUp();
  }

  @Test
  public void testShowStartingLineUp() {
    List<Player> players = playerListHelper();
    for (int i = 10; i < 20; i++) {
      soccerTeam.addPlayer(players.get(i));
    }
    soccerTeam.createSoccerTeam();
    assertEquals(10, soccerTeam.getPlayerListSize());
    soccerTeam.selectStartingLineUp();
    String[] startingInfo = soccerTeam.showStartingLineUp().split("\n");
    assertEquals("GOALIE - Last Name: Lupin; First Name: Remus; Jersey Number: ",
        startingInfo[0].replaceAll("[0-9]", ""));
    assertEquals("DEFENDER - Last Name: Delacour; First Name: Fleur; Jersey Number: ",
        startingInfo[1].replaceAll("[0-9]", ""));
    assertEquals("DEFENDER - Last Name: Scamander; First Name: Newt; Jersey Number: ",
        startingInfo[2].replaceAll("[0-9]", ""));
    assertEquals("MIDFIELDER - Last Name: Black; First Name: Sirius; Jersey Number: ",
        startingInfo[3].replaceAll("[0-9]", ""));
    assertEquals("MIDFIELDER - Last Name: Greengrass; First Name: Astoria; Jersey Number: ",
        startingInfo[4].replaceAll("[0-9]", ""));
    assertEquals("MIDFIELDER - Last Name: Longbottom; First Name: Neville; Jersey Number: ",
        startingInfo[5].replaceAll("[0-9]", ""));
    assertEquals("FORWARD - Last Name: Chang; First Name: Cho; Jersey Number: ",
        startingInfo[6].replaceAll("[0-9]", ""));
  }

  //set up a list of players to be added into the team
  private List<Player> playerListHelper() {
    List<Player> players = new ArrayList<>();
    players.add(new Player("Harry", "Potter", 2013, 10, 8, Position.GOALIE, 5));
    players.add(new Player("Hermione", "Granger", 2014, 4, 13, Position.MIDFIELDER, 5));
    players.add(new Player("Ron", "Weasley", 2015, 3, 10, Position.DEFENDER, 4));
    players.add(new Player("Luna", "Lovegood", 2014, 6, 1, Position.MIDFIELDER, 4));
    players.add(new Player("Draco", "Malfoy", 2016, 12, 20, Position.MIDFIELDER, 3));
    players.add(new Player("Rubeus", "Hagrid", 2016, 5, 25, Position.DEFENDER, 3));
    players.add(new Player("Alastor", "Moody", 2013, 9, 28, Position.DEFENDER, 2));
    players.add(new Player("Dudley", "Dursley", 2014, 3, 31, Position.FORWARD, 1));
    players.add(new Player("Dolores", "Umbridge", 2017, 2, 28, Position.GOALIE, 1));
    players.add(new Player("Minerva", "McGonagall", 2014, 8, 3, Position.FORWARD, 4));
    players.add(new Player("Sirius", "Black", 2013, 10, 22, Position.MIDFIELDER, 5));
    players.add(new Player("Peter", "Pettigrew", 2016, 4, 18, Position.DEFENDER, 1));
    players.add(new Player("Remus", "Lupin", 2017, 8, 6, Position.GOALIE, 5));
    players.add(new Player("Cho", "Chang", 2013, 7, 19, Position.FORWARD, 4));
    players.add(new Player("Pansy", "Parkinson", 2018, 11, 16, Position.MIDFIELDER, 2));
    players.add(new Player("Nymphadora", "Tonks", 2019, 5, 23, Position.DEFENDER, 2));
    players.add(new Player("Neville", "Longbottom", 2015, 2, 7, Position.MIDFIELDER, 4));
    players.add(new Player("Newt", "Scamander", 2014, 3, 17, Position.DEFENDER, 4));
    players.add(new Player("Fleur", "Delacour", 2016, 6, 15, Position.GOALIE, 3));
    players.add(new Player("Astoria", "Greengrass", 2014, 3, 12, Position.MIDFIELDER, 4));
    players.add(new Player("Albus", "Dumbledore", 2013, 12, 9, Position.FORWARD, 5));
    players.add(new Player("Garrick", "Ollivander", 2020, 1, 10, Position.DEFENDER, 1));
    return players;
  }
}