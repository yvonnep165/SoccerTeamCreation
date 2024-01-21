package team;

/**
 * Build the U10 Soccer Team interactively with a graphical user interface.
 */
public class Main {
  /**
   * Build the U10 Soccer Team interactively with a graphical user interface.
   * @param args not used
   */
  public static void main(String[] args) {
    SoccerTeamModel model = new SoccerTeamModelImp();
    TeamView view = new SoccerTeamView("Soccer Team Creation");
    TeamController controller = new SoccerTeamController(model, view);
    controller.startCreateTeam();
  }
}
