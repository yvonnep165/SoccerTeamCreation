## **About/Overview**
This program helps to build soccer teams for children under ten years old. The U10 soccer teams have seven players selected as the starting lineup while all the remaining players are on the bench. 

The program allows the coach to record the information of the candidate players and select a soccer team with at most 20 players and a starting lineup of 7 players. The player's information includes the first name, last name, date of birth, preferred position and skill level based on the coach’s assessment. The coach can form the soccer team once there’re at least 10 candidates on the waiting list. The coach can add or remove players from the waiting list before the team has been formed. The players on the waiting list with the highest level are selected as members of the soccer team. The players selected for the soccer team have their unique jersey numbers randomly assigned. Once we have the soccer team created, the most skilled players in the team are selected as the starting lineup to start the game. The program can assign the positions based on their skill level, their preferred position and what positions are available. With the program, the coach can get a list of all the players selected for the team and a list of all the players in the starting lineup. 


## **List of features**
The program follows the MVC architecture guidelines. The user can create a soccer team with a starting lineup with the GUI. 

The program allows the user to add players to and remove players from a candidate list. The player must be older than 1 and younger than 10. After there’re at least 10 players in the candidate list, the user can create a team. If the team has more than 20 players, the ones with the lowest skill level are ignored. So there’s a maximum of 20 players and a minimum of 10 players in the soccer team. Each player in the team has his/her jersey number unique and randomly assigned and will not be changed. The starting lineup is selected after the team has been formed. The seven players who are the most skilled player in the team are selected and are assigned their preferred position if available. If the preferred position is not available, the player is assigned the positions left in order. The user can get the list of all the players on the soccer team in alphabetical order of last names and the list of all the players on the starting lineup in the order of positions and then the order of last names. 


## **How To Run**
To run the jar file, please download the java file and reach the folder that contains the downloaded jar file in the terminal. Then run java -jar finalProject.jar in the terminal.


## **How to Use the Program**
There’re five pieces of information the user needs to enter for the player, which all have corresponding labels regarding first name, last name, date of birth, preferred position and skill level. The user can input the name of the player in the text fields and select the value for the date of birth, preferred position and skill level in the combo boxes. When the user clicked the “Add” button, the player with the information entered in the text fields and combo boxes is created and added to the waiting list. If either the first name or last name entered by the user is empty, a warning will show up at the bottom left corner and ask the user to input the name. If the user’s age calculated from the input year, month and date is larger than 9 and smaller than 1, a warning will show up and tell the user the age of the player is out of the limit. If the year, month and date information entered represents an invalid date in a year, the warning will show up and tell the user the date is invalid. 

![Alt text](../demo%20pictures/Info%20entered.png)

The players added to the candidate team are shown in the Jlist on the right of the window with their full names. If the number of players is more than the white box can show, a scroll panel feature will show up and the user can scroll to see the whole list of players. If the user wants to remove the player added to the candidate list, the user can click to select the player’s name and then the “Remove” button is enabled once a player is selected. The user can remove the player from the candidate list when clicking the “Remove” button. 

![Alt text](../demo%20pictures/Player%20list.png)

When more than or equal to 10 players are added to the candidate list, the user can click the “Create Team” button to create the U10 soccer team. Before 10 players are added to the candidate list, the user will be notified that there are not enough players to create a team with a warning. Once the “Create Team” button is clicked successfully, the team has been formalized and a new dialogue will show the list of all the players in the team with the first name, last name, and jersey number of each player sorted in alphabetical order of their last names. Once the team is created, the “Add”, “Remove” and “Create Team” buttons are disabled while the “Select Starting Lineup” and “Show Team Again” buttons are enabled.

![Alt text](../demo%20pictures/Team%20created.png)

The “Show Team Again” button once clicked shows the dialogue with the players’ information about the team created previously. The starting lineup has been selected and a new dialogue will show the list of all the players in the starting lineup with the first name, last name, jersey number and position of each player sorted in alphabetical order of the position and then their last names.

![Alt text](../demo%20pictures/Starting%20lineup%20selection.png)

The user can select the starting lineup by clicking the “Select Starting Lineup” button. After clicking, the “Select Starting Lineup” button is disabled while the “Show Starting Lineup Again” button is enabled. 

![Alt text](../demo%20pictures/Reshow%20Starting%20lineup.png)

The “Show Starting Lineup Again” button once clicked shows the dialogue with the players’ information about the starting lineup selected previously. 


## **Assumptions**
I assumed that there’s a situation that two players can have the same information including the first name, last name, date of birth, preferred position and skill levels. So if there’re two players with the same information, I will treat them as two players instead of duplicate entries. I don’t raise exceptions for two identical players. 


## **Citations**
- andrew1234. “Java Swing | JList with examples”. geeksforgeeks. Apr 16, 2021. https://www.geeksforgeeks.org/java-swing-jlist-with-examples/ (accessed Apr 15, 2023)
- “How to Use Lists”. ORACLE. https://docs.oracle.com/javase/tutorial/uiswing/components/list.html (accessed Apr 15, 2023)
- “Swing Examples - Show Alert message Dialog”. Tutorialspoint. https://www.tutorialspoint.com/swingexamples/show_alert_message_dialog.htm (accessed Apr 15, 2023)