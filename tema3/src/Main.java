//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        League league = new League();

        league.addGame(new Game("Team A", "Team B", "1:1"));
        league.addGame(new Game("Team C", "Team A", "2:0"));
        league.addGame(new Game("Team B", "Team C", "1:3"));

        league.printPointsForAllTeams();
    }
}