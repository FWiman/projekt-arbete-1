package se.Fredrik.projektarbete;

import java.util.Random;

public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public int rollDice() {
        Random rnd = new Random();
        return rnd.nextInt(6) + 1;
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

}
