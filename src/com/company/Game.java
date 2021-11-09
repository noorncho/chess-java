package com.company;

import com.company.pieces.*;

public class Game {
    private ChessBoard chessBoard;
    //private Knight knight;
    private String player1, player2;

    public Game(String player1, String player2){
        chessBoard = new ChessBoard();
        this.player1 = player1;
        this.player2 = player2;
        for(int col = 0; col < 8; col++){
            ChessPiece pawn = new Pawn(player1, new Location(1, col), this);
            chessBoard.addPiece(pawn, pawn.getLocation());
        }

        ChessPiece rook1 = new Rook(player1, new Location(0, 0), this);
        chessBoard.addPiece(rook1, rook1.getLocation());

        ChessPiece knight1 = new Knight(player1, new Location(0, 1), this);
        chessBoard.addPiece(knight1, knight1.getLocation());

        ChessPiece bishop1 = new Bishop(player1, new Location(0, 2), this);
        chessBoard.addPiece(bishop1, bishop1.getLocation());

        ChessPiece king = new King(player1, new Location(0, 3), this);
        chessBoard.addPiece(king, king.getLocation());

        ChessPiece queen = new Queen(player1, new Location(0, 4), this);
        chessBoard.addPiece(queen, queen.getLocation());

        ChessPiece bishop2 = new Bishop(player1, new Location(0, 5), this);
        chessBoard.addPiece(bishop2, bishop2.getLocation());

        ChessPiece knight2 = new Knight(player1, new Location(0, 6), this);
        chessBoard.addPiece(knight2, knight2.getLocation());

        ChessPiece rook2 = new Rook(player1, new Location(0, 7), this);
        chessBoard.addPiece(rook2, rook2.getLocation());
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }
}
