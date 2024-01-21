package team;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This class represents the GUI implementation of the View component of the soccer team
 * creation solution.
 * If offers all the operations mandated by the TeamView interface.
 */
public class SoccerTeamView extends JFrame implements TeamView {
  private JLabel title;
  private JLabel firstNameLable;
  private JLabel lastNameLable;
  private JTextField firstName;
  private JTextField lastName;
  private JLabel yearBirth;
  private JLabel monthBirth;
  private JLabel dateBirth;
  private JComboBox<Integer> year;
  private JComboBox<Integer> month;
  private JComboBox<Integer> date;
  private JLabel position;
  private JComboBox<Position> preferredPosition;
  private JLabel level;
  private JComboBox<Integer> skillLevel;
  private JButton addButton;
  private JButton removeButton;
  private DefaultListModel<String> listModel;
  private JList<String> candidateList;
  private JScrollPane scroll;
  private JTextArea warning;
  private JButton create;
  private JButton selectStart;
  private JButton showTeam;
  private JButton showStart;
  private String team;
  private String starting;
  private boolean reshow;

  /**
   * Initialize the window for the soccer team creation solution.
   * @param caption Caption for the window.
   */
  public SoccerTeamView(String caption) {
    super(caption);

    setSize(750, 500);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    Container control = getContentPane();
    control.setLayout(null);

    title = new JLabel("Add Candidates For The Team");
    title.setFont(new Font("Dialog", Font.BOLD, 20));
    title.setSize(500, 30);
    title.setLocation(250, 30);
    this.add(title);

    firstNameLable = new JLabel("First Name");
    firstNameLable.setFont(new Font("Dialog", Font.PLAIN, 15));
    firstNameLable.setBounds(100, 100, 100, 20);
    this.add(firstNameLable);

    firstName = new JTextField();
    firstName.setFont(new Font("Dialog", Font.PLAIN, 15));
    firstName.setBounds(195, 100, 190, 20);
    this.add(firstName);

    lastNameLable = new JLabel("Last Name");
    lastNameLable.setFont(new Font("Dialog", Font.PLAIN, 15));
    lastNameLable.setBounds(100, 130, 100, 20);
    this.add(lastNameLable);

    lastName = new JTextField();
    lastName.setFont(new Font("Dialog", Font.PLAIN, 15));
    lastName.setBounds(195, 130, 190, 20);
    this.add(lastName);

    yearBirth = new JLabel("Year");
    yearBirth.setFont(new Font("Dialog", Font.PLAIN, 15));
    yearBirth.setBounds(100, 160, 100, 20);
    this.add(yearBirth);

    Integer[] years = new Integer[10];
    for (int i = 0; i < 10; i++) {
      years[i] = 2013 + i;
    }
    year = new JComboBox<>(years);
    year.setFont(new Font("Dialog", Font.PLAIN, 15));
    year.setBounds(195, 160, 100, 20);
    this.add(year);

    monthBirth = new JLabel("Month");
    monthBirth.setFont(new Font("Dialog", Font.PLAIN, 15));
    monthBirth.setBounds(100, 190, 100, 20);
    this.add(monthBirth);

    Integer[] months = new Integer[12];
    for (int i = 0; i < 12; i++) {
      months[i] = 1 + i;
    }
    month = new JComboBox<>(months);
    month.setFont(new Font("Dialog", Font.PLAIN, 15));
    month.setBounds(195, 190, 100, 20);
    this.add(month);

    dateBirth = new JLabel("Date");
    dateBirth.setFont(new Font("Dialog", Font.PLAIN, 15));
    dateBirth.setBounds(100, 220, 100, 20);
    this.add(dateBirth);

    Integer[] dates = new Integer[31];
    for (int i = 0; i < 31; i++) {
      dates[i] = 1 + i;
    }
    date = new JComboBox<>(dates);
    date.setFont(new Font("Dialog", Font.PLAIN, 15));
    date.setBounds(195, 220, 100, 20);
    this.add(date);

    position = new JLabel("Preferred Position");
    position.setFont(new Font("Dialog", Font.PLAIN, 15));
    position.setBounds(100, 250, 130, 20);
    this.add(position);

    preferredPosition = new JComboBox<>(Position.values());
    preferredPosition.setFont(new Font("Dialog", Font.PLAIN, 15));
    preferredPosition.setBounds(230, 250, 150, 20);
    this.add(preferredPosition);

    level = new JLabel("Skill Level");
    level.setFont(new Font("Dialog", Font.PLAIN, 15));
    level.setBounds(100, 280, 130, 20);
    this.add(level);

    Integer[] levels = new Integer[5];
    for (int i = 0; i < 5; i++) {
      levels[i] = 1 + i;
    }
    skillLevel = new JComboBox<>(levels);
    skillLevel.setFont(new Font("Dialog", Font.PLAIN, 15));
    skillLevel.setBounds(210, 280, 130, 20);
    this.add(skillLevel);

    addButton = new JButton("Add");
    addButton.setFont(new Font("Dialog", Font.BOLD, 15));
    addButton.setBounds(150, 320, 90, 25);
    this.add(addButton);

    removeButton = new JButton("Remove");
    removeButton.setFont(new Font("Dialog", Font.BOLD, 15));
    removeButton.setBounds(480, 320, 100, 25);
    removeButton.setEnabled(false);
    this.add(removeButton);

    listModel = new DefaultListModel<>();
    candidateList = new JList<>(listModel);
    candidateList.addListSelectionListener(new ListSelectionListener() {
      @Override public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          if (candidateList.getSelectedIndex() == -1) {
            removeButton.setEnabled(false);
          } else {
            removeButton.setEnabled(true);
          }
        }
      }
    });
    candidateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scroll = new JScrollPane(candidateList);
    control.add(scroll);
    scroll.setBounds(400, 100, 250, 200);
    this.add(scroll);

    create = new JButton("Create Team");
    create.setFont(new Font("Dialog", Font.BOLD, 15));
    create.setBounds(460, 350, 150, 25);
    this.add(create);

    selectStart = new JButton("Select Starting Lineup");
    selectStart.setFont(new Font("Dialog", Font.BOLD, 15));
    selectStart.setBounds(430, 380, 200, 25);
    selectStart.setEnabled(false);
    this.add(selectStart);

    showTeam = new JButton("Show Team Again");
    showTeam.setFont(new Font("Dialog", Font.BOLD, 15));
    showTeam.setBounds(440, 410, 180, 25);
    showTeam.setEnabled(false);
    this.add(showTeam);

    showStart = new JButton("Show Starting Lineup Again");
    showStart.setFont(new Font("Dialog", Font.BOLD, 15));
    showStart.setBounds(410, 440, 250, 25);
    showStart.setEnabled(false);
    this.add(showStart);

    warning = new JTextArea();
    warning.setFont(new Font("Dialog", Font.BOLD, 15));
    warning.setBounds(100, 360, 300, 40);
    warning.setEditable(false);
    warning.setLineWrap(true);
    warning.setBackground(this.getBackground());
    this.add(warning);

    setResizable(false);
    setVisible(true);
  }

  @Override
  public void addPlayer(TeamController controller) {
    addButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
          String playerFirstName = firstName.getText();
          String playerLastName = lastName.getText();
          int playerYear = (Integer) year.getSelectedItem();
          int playerMonth = (Integer) month.getSelectedItem();
          int playerDate = (Integer) date.getSelectedItem();
          Position playerPosition = (Position) preferredPosition.getSelectedItem();
          int playerSkillLevel = (Integer) skillLevel.getSelectedItem();
          controller.addCandidate(playerFirstName, playerLastName, playerYear, playerMonth,
              playerDate, playerPosition, playerSkillLevel);
        }
      }
    });
  }

  @Override
  public void updateCandidateList(String newPlayer) {
    listModel.addElement(newPlayer);
  }

  @Override
  public void removePlayer(TeamController controller) {
    removeButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeButton) {
          int index = candidateList.getSelectedIndex();
          listModel.remove(index);
          controller.removeCandidate(index);
        }
      }
    });
  }

  @Override
  public void createTeam(TeamController controller) {
    create.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
          controller.createTeam();
        }
      }
    });
  }

  @Override
  public void showTeamList(String playerList) {
    team = playerList;
    JOptionPane.showMessageDialog(this, team, "Soccer Team Players List",
        JOptionPane.PLAIN_MESSAGE);
    create.setEnabled(false);
    showTeam.setEnabled(true);
    addButton.setEnabled(false);
    removeButton.setEnabled(false);
    candidateList.setEnabled(false);
    if (!reshow) {
      selectStart.setEnabled(true);
    }
  }

  @Override
  public void selectStartingLineup(TeamController controller) {
    selectStart.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectStart) {
          controller.createStartingLineup();
        }
      }
    });
  }

  @Override
  public void showStartingLineup(String startingList) {
    starting = startingList;
    JOptionPane.showMessageDialog(this, starting, "Starting LineUp Players List",
        JOptionPane.PLAIN_MESSAGE);
    selectStart.setEnabled(false);
    showStart.setEnabled(true);
  }

  @Override
  public void reshowTeamList() {
    showTeam.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showTeam) {
          reshow = true;
          showTeamList(team);
        }
      }
    });
  }

  @Override
  public void reshowStartingList() {
    showStart.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showStart) {
          showStartingLineup(starting);
        }
      }
    });
  }

  @Override
  public void resetToDefault() {
    firstName.setText("");
    lastName.setText("");
    year.setSelectedIndex(0);
    month.setSelectedIndex(0);
    date.setSelectedIndex(0);
    preferredPosition.setSelectedIndex(0);
    skillLevel.setSelectedIndex(0);
  }

  @Override
  public void showWarning(String exception) {
    warning.setText(exception);
  }
}
