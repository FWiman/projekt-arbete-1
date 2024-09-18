package se.Fredrik.projektarbete;

import java.util.Scanner;

public class DiceGame {

    private Scoreboard scoreboard;
    private int maxRounds;


    public DiceGame() {
        scoreboard = new Scoreboard();
    }

    public void startGame() {
        Menu menu = new Menu();
        int choice = menu.displayMenu();


        switch (choice) {
            case 1:
                // Singleplayer
                maxRounds = menu.chooseRound();
                startSingleplayer();
                break;

                case 2:
                    // Multiplayer
                    maxRounds = menu.chooseRound();
                    startMultiplayer();
                    break;

                    case 3:
                        // Quit Game
                        System.out.println("Thanks for playing!");
                        break;

                        default:
                            System.out.println("Invalid choice!");
        }


    }

    private void startSingleplayer() {

        Player player = new Player("Player");
        Player ai = new Player("AI");
        scoreboard.addPlayer(player);
        scoreboard.addPlayer(ai);

        for (int i = 0; i < maxRounds; i++) {
            System.out.println("Round " + (i + 1));
            playRound(player, ai, true);
        }

        endGame();


    }


    private void startMultiplayer() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        scoreboard.addPlayer(player1);
        scoreboard.addPlayer(player2);

        for(int i = 0; i < maxRounds; i++) {
            System.out.println("Round " + (i + 1));
            playRound(player1, player2, false);
        }

        endGame();

    }

    private void playRound(Player player1, Player player2, boolean isAI) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press ENTER to roll the dice...");
        scanner.nextLine();

        int playerRoll = player1.rollDice();
        System.out.println(player1.getName() + "'s roll: " + playerRoll);

        int opponentRoll;

        if (isAI) {
            opponentRoll = player2.rollDice();
            System.out.println(player2.getName() + " rolled: " + opponentRoll);
        } else {
//            System.out.println(player2.getName() + "'s turn. Press ENTER to roll the dice... ");
//            scanner.nextLine();
            opponentRoll = player2.rollDice();
            System.out.println(player2.getName() + " rolled: " + opponentRoll);
        }

        if(playerRoll > opponentRoll) {
            player1.addScore(1);
            System.out.println(player1.getName() + " wins this round.");
            System.out.println("------------------------------");
        } else if(playerRoll < opponentRoll) {
            player2.addScore(1);
            System.out.println(player2.getName() + " wins this round.");
            System.out.println("------------------------------");
        } else {
            System.out.println("Its a tie!");
            System.out.println("------------------------------");
        }


    }

    private void endGame() {
        System.out.println("Final score is: ");
        scoreboard.displayScoreboard();

        Player winner = scoreboard.determineWinner();
        System.out.println("The winner is " + winner.getName());
    }



}
