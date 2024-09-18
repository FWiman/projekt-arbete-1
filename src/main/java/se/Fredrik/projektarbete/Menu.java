package se.Fredrik.projektarbete;

import java.util.Scanner;

public class Menu {
    private Scanner input;

    public Menu() {
        input = new Scanner(System.in);
    }


    public int displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1) Singleplayer vs AI");
        System.out.println("2) Multiplayer");
        System.out.println("3) Exit");

        return input.nextInt();

    }

    public int chooseRound(){
        System.out.println("Choose number of rounds:");
        return input.nextInt();
    }


}
