// Created by: Romain HEURTAUX
// Date: 2025-05-15

import java.util.Scanner;

public class Screen {

    /* Variables */
    private Partie Game;
    private int[][] pos;

    public Screen(Partie Game) {
        this.Game = Game;
    }

    public Screen() {
        this.Game = new Partie("White");    // by default, on a new game White starts
    }

    /* Setter & getter */
    public Partie getGame() {
        return this.Game;
    }

    public void setGame(Partie Game) {
        this.Game = Game;
    }
    public int[][] getPos() {
        return this.pos;
    }

    /* Methods */
    public void actualise() {
        this.askuser();
    }

    private int[] askuser(){
        System.out.println("Au tour de : " + Game.getCurrentPlayer());
        System.out.println("Séléctionnez votre destination (ex: 1 2) : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] pos = input.split(" ");
        int x = Integer.parseInt(pos[0]);
        int y = Integer.parseInt(pos[1]);
        System.out.println("Vous avez choisi la position : " + x + "-" + y);
        int[] pos1 = new int[2];
        pos1[0] = x;
        pos1[1] = y;
        return pos1;
    }
}