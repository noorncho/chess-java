package com.company;

import com.company.pieces.*;

public class Game {
    private ChessBoard chessBoard;
    private String player1, player2;

    public Game(String player1, String player2){
        chessBoard = new ChessBoard();
        this.player1 = player1;
        this.player2 = player2;
        initialisePlayers();
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public void initialisePlayers(){
        for(int col = 0; col < 8; col++){
            ChessPiece pawn = new Pawn(player1, new Location(1, col), this);
            chessBoard.addPiece(pawn, pawn.getLocation());
            ChessPiece pawn2 = new Pawn(player2, new Location(6, col), this);
            chessBoard.addPiece(pawn2, pawn2.getLocation());
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

        //Player 2 - pieces
        ChessPiece rook1_2 = new Rook(player2, new Location(7, 0), this);
        chessBoard.addPiece(rook1_2, rook1_2.getLocation());

        ChessPiece knight1_2 = new Knight(player2, new Location(7, 1), this);
        chessBoard.addPiece(knight1_2, knight1_2.getLocation());

        ChessPiece bishop1_2 = new Bishop(player2, new Location(7, 2), this);
        chessBoard.addPiece(bishop1_2, bishop1_2.getLocation());

        ChessPiece king_2 = new King(player2, new Location(7, 3), this);
        chessBoard.addPiece(king_2, king_2.getLocation());

        ChessPiece queen_2 = new Queen(player2, new Location(7, 4), this);
        chessBoard.addPiece(queen_2, queen_2.getLocation());

        ChessPiece bishop2_2 = new Bishop(player2, new Location(7, 5), this);
        chessBoard.addPiece(bishop2_2, bishop2_2.getLocation());

        ChessPiece knight2_2 = new Knight(player2, new Location(7, 6), this);
        chessBoard.addPiece(knight2_2, knight2_2.getLocation());

        ChessPiece rook2_2 = new Rook(player2, new Location(7, 7), this);
        chessBoard.addPiece(rook2_2, rook2_2.getLocation());
    }
}
