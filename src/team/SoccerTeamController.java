package team;

/**
 * This class represents the implementation of the Controller component of
 * the soccer team creation solution.
 * If offers all the operations mandated by the TeamController interface.
 */
public class SoccerTeamController implements TeamController {
  private final SoccerTeamModel model;
  private final TeamView view;

  /**
   * Constructor a controller for the interactive, graphical soccer team creation solution.
   * @param m the model of the soccer team creation solution that builds the team
   * @param v the view of the soccer team creation solution that displays to the user
   */
  public SoccerTeamController(SoccerTeamModel m, TeamView v) {
    model = m;
    view = v;
  }

  @Override
  public void startCreateTeam() {
    view.addPlayer(this);
    view.removePlayer(this);
    view.createTeam(this);
    view.selectStartingLineup(this);
    view.reshowTeamList();
    view.reshowStartingList();
  }

  @Override
  public void addCandidate(String firstName, String lastName, int year, int month, int date,
      Position preferredPosition, int skillLevel) {
    boolean validAdd;
    try {
      model.addPlayer(
          new Player(firstName, lastName, year, month, date, preferredPosition, skillLevel));
      validAdd = true;
    } catch (IllegalStateException | IllegalArgumentException e) {
      view.showWarning(e.getMessage());
      validAdd = false;
    }
    if (validAdd) {
      Player newPlayer = model.getPlayerList().get(model.getPlayerListSize() - 1);
      view.updateCandidateList(newPlayer.getFirstName() + " " + newPlayer.getLastName());
      view.resetToDefault();
      view.showWarning("");
    }
  }

  @Override
  public void removeCandidate(int index) {
    Player player = model.getPlayerList().get(index);
    model.removePlayer(player);
  }

  @Override
  public void createTeam() {
    boolean validCreate;
    try {
      model.createSoccerTeam();
      validCreate = true;
    } catch (IllegalStateException e) {
      view.showWarning(e.getMessage());
      validCreate = false;
    }
    if (validCreate) {
      String teamList = model.showListOfTeamPlayer();
      view.showTeamList(teamList);
    }
  }

  @Override
  public void createStartingLineup() {
    model.selectStartingLineUp();
    String startingLineup = model.showStartingLineUp();
    view.showStartingLineup(startingLineup);
  }
}
