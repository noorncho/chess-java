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
            ChessPiece piece = gameBoard.getPieceAt(sourceLocation);
            while(piece == null){
                System.out.println("No piece at that location. Try Again.");
                System.out.println("Enter the location of the piece you want to move (row, column): ");
                sourceRow = scan.nextInt();
                sourceCol = scan.nextInt();
                sourceLocation = new Location(sourceRow, sourceCol);
                piece = gameBoard.getPieceAt(sourceLocation);
            }

            System.out.println("Enter the location where you want to move the " + piece.getType() + " to (row, " +
                    "column): ");
            int destinationRow = scan.nextInt();
            int destinationCol = scan.nextInt();
            Location destinationLocation = new Location(destinationRow, destinationCol);
            ChessPiece destinationPieceCheck = gameBoard.getPieceAt(destinationLocation);
            while(destinationPieceCheck != null){
                System.out.println("There is already something at this location. Try Again.");
                System.out.println("Enter the location where you want to move the " + piece.getType() + " to (row, " +
                        "column): ");
                destinationRow = scan.nextInt();
                destinationCol = scan.nextInt();
                destinationLocation = new Location(destinationRow, destinationCol);
                destinationPieceCheck = gameBoard.getPieceAt(destinationLocation);
            }
            piece.moveTo(destinationLocation);
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

    }
}
