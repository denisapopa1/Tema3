import java.util.ArrayList;
import java.util.List;

public class League {
    private List<Game> games;

    public League() {
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGames(String teamId) {
        List<Game> teamGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getTeam1().equals(teamId)||game.getTeam2().equals(teamId))
                teamGames.add(game);
        }
        return teamGames;
    }

    public int getPointsForTeam(String teamId) {
        int points = 0;
        for (Game game : getGames(teamId)) {
            String[] scores = game.getScore().split(":");
            int score1 = Integer.parseInt(scores[0]);
            int score2 = Integer.parseInt(scores[1]);

            if (game.getTeam1().equals(teamId)) {
                if (score1 > score2)
                    points = points + 3;
                else if (score1 == score2)
                    points = points + 1;
            } else if (game.getTeam2().equals(teamId)) {
                if (score2 > score1)
                    points = points + 3;
                else if (score1 == score2)
                    points = points + 1;

            }
        }
        return points;
    }

    public void printPointsForAllTeams() {
        List<String> teams = new ArrayList<>();
        for (Game game : games) {
            if (!teams.contains(game.getTeam1())) teams.add(game.getTeam1());
            if (!teams.contains(game.getTeam2())) teams.add(game.getTeam2());
        }

        for (String team : teams) {
            System.out.println("Team " + team + " has " + getPointsForTeam(team) + " points.");
        }
    }

}
