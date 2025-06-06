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
    public int[][] actualise() {
        System.out.println(this.Game.toStringChessboard());
        this.printHistory();
        int[][] selectedPositions = new int[2][2];
        selectedPositions[0] = this.askuser(true); 
        selectedPositions[1] = this.askuser(false); 
        return selectedPositions;
    }

    private int[] askuser(Boolean tour){
        if(tour){
            System.out.println("Au tour de : " + Game.getCurrentPlayer());
            System.out.println("Séléctionnez votre Pion (ex: 1 2) : ");
        } else {
            System.out.println("Séléctionnez votre destination (ex: 1 2) : ");
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        /* Ancienne version (au cas ou)
        String[] pos = input.split(" ");
        int x = Integer.parseInt(pos[0]);
        int y = Integer.parseInt(pos[1]);
        */
        int[] pos1 = Echiquier.coord_str_to_int(input);
        System.out.println("Vous avez choisi la position : " + input);
        return pos1;
    }

    private void printHistory()
    {
        /* Print in a beautiful way the current game history on stdout */ 
        
        Move[] latest_moves = this.Game.getLast();

        System.out.println("+---   History   ------");
        for(int i = 0; i < latest_moves.length; i++)
        {
            System.out.println("| " + latest_moves[i].toString());
        }
        System.out.println("+----------------------");
    }
}