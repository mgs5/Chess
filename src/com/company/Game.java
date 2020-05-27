package com.company;

import java.util.Arrays;

public class Game {
    // The following five constants were defined in the starter code (kt54)
    private static String WHITEPLAYS_MSG    = "White plays. Enter move:";
    private static String BLACKPLAYS_MSG    = "Black plays. Enter move:";
    private static String ILLEGALMOVE_MSG   = "Illegal move!";
    private static String WHITEWINS_MSG     = "White wins!";
    private static String BLACKWINS_MSG     = "Black wins!";

    //attributes to play the game
    private Board gameBoard;
    private char piece;
    private int boardSize = 8;

    //turn control
    boolean whiteToPlay = true;

    // Minimal constructor. Expand as needed (kt54)
    public Game() {
        gameBoard = new Board();

    }

    //converts String inputs into array coordinates
    public int[] convertInput(String input) {
        int [] position = new int [2];
        int boardSize = 8;
        for(int i = 0; i < boardSize; i++) {
            if (input.charAt(0) == (char) i + 'a') {
                position[1] = i;
            }
            if (input.charAt(1) == i + '1') {
                position[0] = boardSize - (i + 1);
            }
        }
        return  position;
    }

    //checks if move is valid
    public boolean isMoveValid(char piece, int [] position1, int [] position2){
        if(position1[0] >= boardSize || position1[0] < 0 || position1[1] >= boardSize || position1[1] < 0 ||
                position2[0] >= boardSize || position2[0] <0 || position2[1] >= boardSize || position2[1] < 0) {
            System.out.print(ILLEGALMOVE_MSG);
            return false;
        }
        if(piece == '.' ){
            System.out.print(ILLEGALMOVE_MSG);
            return false;
        }
        return true;


    }



    // Build on this method to implement game logic.
    public void play(){
        EasyIn2 reader = new EasyIn2();
        gameBoard = new Board();

        //user interface loop
        String command = "";
        do {
            System.out.print("Type 'play' to play, or type 'quit' at anytime to quit the game.");
            command = reader.getString();

            if(command.equals("play")) {
                gameBoard.printBoard();
                System.out.println(WHITEPLAYS_MSG);

                String pos1 = reader.getString();
                String pos2 = reader.getString();

                int[] position1 = convertInput(pos1);
                int[] position2 = convertInput(pos2);
                System.out.print(Arrays.toString(position1));

                piece = gameBoard.getPiece(position1);


                System.out.println();
            }

        } while (!command.equals("quit"));

    }
}
