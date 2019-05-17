import javax.swing.*;
import java.lang.Math;

public class Team {

    private String name;
    private String location;
    private int nWins;
    private int nLosses;
    private double offense;
    private double defense;

    public static double luck() {
        return (Math.random() > 0.5)? Math.random() : 1 - Math.random();
    }

    public Team(String name, String location) {
        this.name = name;
        this.location = location;
        nWins = 0;
        nLosses = 0;
        offense = luck();
        defense = luck();
    }
    public static Team play(Team team1, boolean isHome, Team team2) {
            double homeScore;
            double awayScore;

        if (isHome) {
            homeScore = (team1.getOffense() + team1.getDefense() + 0.2) * luck();
            awayScore = (team2.getOffense() + team2.getDefense()) * luck();
            if (homeScore > awayScore) {
                team1.nWins++;
                team2.nLosses++;
                return team1;
            } else {
                team1.nLosses++;
                team2.nWins++;
                return team2;
            }
        } else {
            homeScore = (team2.getOffense() + team2.getDefense() + 0.2) * luck();
            awayScore = (team1.getOffense() + team1.getDefense()) * luck();
            if (homeScore > awayScore) {
                team1.nLosses++;
                team2.nWins++;
                return team2;
            } else {
                team2.nLosses++;
                team1.nWins++;
                return team1;
            }
        }

    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public int getN_Wins() {
        return nWins;
    }
    public int getN_Losses() {
        return nLosses;
    }
    public double getOffense() {
        return offense;
    }
    public double getDefense() {
        return defense;
    }
    public int calcTotalGames() {
        int totalGames = nWins + nLosses;
        return totalGames;
    }
    public double calcWinRate() {
        return (((double)getN_Wins()) / calcTotalGames()) * 100;
    }
    public double calcLossRate() {
        return (((double)getN_Losses()) / calcTotalGames()) * 100;
    }
    public int calcDifference() {
       return Math.abs(getN_Wins() - getN_Losses());
    }
    public String generateStats() {
            return (getName() +  " (" + getLocation() + ")" + "\n" + "Total games: " + calcTotalGames() + "\n" +
                    "No. wins: " + getN_Wins() + " (" + String.format("%.2f", calcWinRate()) + "%)") + "\n" +
                    ("No. losses: " + getN_Losses() + " (" + String.format("%.2f", calcLossRate()) + "%)") +
                    "\n" + "Difference: " + calcDifference();
    }

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog(null, "Enter name and location for home team separated by a comma(,)");

        name = name.replaceAll(" ", "");
        int comma = name.indexOf(',');

        String homeTeam = name.substring(1, comma);
        String home = homeTeam.toLowerCase();
        String home1 = name.substring(0,1);
        String homeTeam1 = home1.toUpperCase();
        String homeTeam2 = homeTeam1 + home;

        String college = name.substring(comma + 2);
        String college1 = college.toLowerCase();
        String college2 = name.substring(comma + 1, comma + 2);
        String college3 = college2.toUpperCase();

        String collegeBoom = college3 + college1;

        Team team1 = new Team(homeTeam2, collegeBoom);

        String nameTwo =JOptionPane.showInputDialog(null, "Enter name and location for away team separated by a comma(,)");

        nameTwo = nameTwo.replaceAll(" ", "");
        int comma1 = nameTwo.indexOf(',');

        String awayTeam = nameTwo.substring(1, comma1);
        String away = awayTeam.toLowerCase();
        String away1 = nameTwo.substring(0,1);
        String away2 = away1.toUpperCase();
        String awayTeam1 = away2 + away;

        String awayCollege = nameTwo.substring(comma1 + 2);
        String awayCollege1 = awayCollege.toLowerCase();
        String awayCollege2 = nameTwo.substring(comma1 + 1, comma1 + 2);
        String awayCollege3 = awayCollege2.toUpperCase();

        String collegeBoom1 = awayCollege3 + awayCollege1;

        Team team2 = new Team(awayTeam1, collegeBoom1);

        double offense1 = team1.getOffense();
        double defense1 = team1.getDefense();

        double offense2 = team2.getOffense();
        double defense2 = team2.getDefense();

        JOptionPane.showMessageDialog(null, "Home team is: " + homeTeam2 + " from " + collegeBoom + " " + String.format(
                "%.2f", offense1) + " (offense) " + String.format("%.2f", defense1) + " " + "(defense)");
        JOptionPane.showMessageDialog(null, "Away team is: " + awayTeam1 + " from " + collegeBoom1 + " " + String.format(
                "%.2f", offense2) + " (offense) " + String.format("%.2f", defense2) + " " + "(defense)");

        Team win = play(team1, true, team2);

        JOptionPane.showMessageDialog(null, "Round 1 " + "\n" + "Winner is: " + win.getName() + " from " + win.getLocation() + " " +
                String.format("%.2f", win.getOffense()) + " (offense) " + String.format("%.2f", win.getDefense()) + " " + "(defense)" );

        Team win2 = play(team1, true, team2);
        JOptionPane.showMessageDialog(null, "Round 2 " + "\n" + "Winner is: " + win2.getName() + " from " + win2.getLocation() + " " +
                String.format("%.2f", win2.getOffense()) + " (offense) " + String.format("%.2f", win2.getDefense()) + " " + "(defense)" );

        Team win3 = play(team1, true, team2);
        JOptionPane.showMessageDialog(null, "Round 3 " + "\n" + "Winner is: " + win3.getName() + " from " + win3.getLocation() + " " +
                String.format("%.2f", win3.getOffense()) + " (offense) " + String.format("%.2f", win3.getDefense()) + " " + "(defense)" );

        JOptionPane.showMessageDialog(null, team1.generateStats());
        JOptionPane.showMessageDialog(null, team2.generateStats());


    }
}
