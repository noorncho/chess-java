package com.company;

import com.company.pieces.ChessPiece;

public class ChessBoard {
    private String[][] board;
    private ChessPiece[][] chessBoard;

    public ChessBoard(){
        initializeBoard();
    }

    public void initializeBoard(){
        board = new String[8][8];
        for (int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                board[y][x] = " _ ";
            }
        }

        chessBoard = new ChessPiece[8][8];
        /*for(int i = 0; i < chessBoard.length; i++){
            System.out.println(Arrays.toString(chessBoard[i]));
        }*/
    }

    /*public boolean isPieceAt(int row, int col){
        Game game = new Game();
        int x = game.getKnight().getLocation().getRow();
        int y = game.getKnight().getLocation().getCol();

        if(x == row && y == col){
            return true;
        }else{
            return false;
        }
    }*/
    public ChessPiece getPieceAt(int row, int col){
        ChessPiece piece = chessBoard[row][col];
        return piece;
    }

    public ChessPiece getPieceAt(Location location){
        int row = location.getRow();
        int col = location.getCol();
        ChessPiece piece = chessBoard[row][col];
        return piece;
    }

    public void addPiece(ChessPiece chessPiece, Location location){
        int row = location.getRow();
        int col = location.getCol();

        board[row][col] = " " + chessPiece.getId() + " ";
        chessBoard[row][col] = chessPiece;
    }

    public void placePieceAt(ChessPiece chessPiece, Location location){
        int row = location.getRow();
        int col = location.getCol();

        //Puts the piece on the board at the given location
        board[row][col] = " " + chessPiece.getId() + " ";
        chessBoard[row][col] = chessPiece;
    }

    public void removePiece(Location location){
        int row = location.getRow();
        int col = location.getCol();
        board[row][col] = " _ "; //Replaces the knight piece with a blank space
        chessBoard[row][col] = null;
    }

    public void printBoard(){
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(chessBoard[row][col] == null){
                    System.out.print(" _ ");
                }else{
                    System.out.print(" "+ chessBoard[row][col].getId() + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}
