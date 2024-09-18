package se.Fredrik.projektarbete;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private List<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void displayScoreboard() {
        for (Player player : players) {
            System.out.println(player.getName() + " : " + player.getScore());
        }
    }

    public Player determineWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        return winner;
    }



}
