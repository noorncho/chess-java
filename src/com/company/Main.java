package com.company;

import com.company.pieces.ChessPiece;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();

        Game game = new Game("p1", "p2");
        ChessBoard gameBoard = game.getChessBoard();
        gameBoard.printBoard();

        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to \"move\" or \"quit\"?: ");

        while(!scan.next().equalsIgnoreCase("quit")){ // Checks the users input
            System.out.println("Enter the location of the piece you want to move (row, column): ");
            //Equates the value that have been read in to the row or column value
            int sourceRow = scan.nextInt();
            int sourceCol = scan.nextInt();
            Location sourceLocation = new Location(sourceRow, sourceCol);

            //Check that there is a piece at the source location
            /*while(gameBoard.isPieceAt(sourceLocation)){
                System.out.println("No piece at that location. Try Again or \"quit\".");
                System.out.println("Enter the location of the piece you want to move (row, column): ");
                sourceRow = scan.nextInt();
                sourceCol = scan.nextInt();
                sourceLocation = new Location(sourceRow, sourceCol);
            }
            //End the game
            if(scan.next().equalsIgnoreCase("quit")){
                System.out.println("End of Game");
                System.out.println("Thank you for playing");
                System.exit(0);
            }*/
            ChessPiece piece = gameBoard.getPieceAt(sourceLocation);

            //Get row and column values of the destination location
            System.out.println("Enter the location where you want to move the " + piece.getType() + " to (row, " +
                    "column): ");
            int destinationRow = scan.nextInt();
            int destinationCol = scan.nextInt();
            Location destinationLocation = new Location(destinationRow, destinationCol);

            //Check that there is no piece at the destination location
            /*while(gameBoard.isPieceAt(destinationLocation) || !scan.next().equalsIgnoreCase("quit")){
                System.out.println("There is already something at this location. Try Again or \"quit\".");
                System.out.println("Enter the location where you want to move the " + piece.getType() + " to (row, " +
                        "column): ");
                destinationRow = scan.nextInt();
                destinationCol = scan.nextInt();
                destinationLocation = new Location(destinationRow, destinationCol);
            }
            //End the game
            if(scan.next().equalsIgnoreCase("quit")){
                System.out.println("End of Game");
                System.out.println("Thank you for playing");
                System.exit(0);
            }*/
            piece.moveTo(destinationLocation);

            //Show updated board after a successful move
            gameBoard.printBoard();

            //Asks user to enter a new input
            System.out.println("Do you want to \"move\" or \"quit\"?: ");
        }

        System.out.println("End of Game");
        System.out.println("Thank you for playing");
        System.exit(0); // End the game if the user enters the character.*/
        /*int[][] array = new int[8][8];
        for(int row = 0; row < 8; row++){
            for(int col=0;col<8; col++){
                System.out.print(" " +row + "£" + col + " ");
            }
            System.out.println();
        }*/
    }

    public static void menu(){
        System.out.println("This is a 2-player chess game");
        System.out.println("");
    }
}
