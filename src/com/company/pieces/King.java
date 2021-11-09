package com.company.pieces;

import com.company.ChessBoard;
import com.company.Game;
import com.company.Location;

public class King extends ChessPiece{
    public King(String owner, Location initialLocation, Game game) {
        super("King", "K", owner, initialLocation, game);
    }

    public Boolean canMoveTo(Location newLocation){
        ChessBoard board = getGame().getChessBoard();
        if(board.getPieceAt(newLocation) == null){

            //Moving forward or backward
            if(newLocation.getCol() == this.getLocation().getCol()){
                if(Math.abs(newLocation.getRow() - this.getLocation().getRow()) == 1){
                    return true;
                }
            }

            //Moving left or right
            if(newLocation.getRow() == this.getLocation().getRow()){
                if(Math.abs(newLocation.getCol() - this.getLocation().getCol()) == 1){
                    return true;
                }
            }

            //Moving Diagonally
            if((Math.abs(newLocation.getCol() - this.getLocation().getCol()) == 1)
                    && (Math.abs(newLocation.getRow() - this.getLocation().getRow()) == 1)){
                return true;
            }
        }

        return false;
    }

    public void moveTo(Location newLocation){
        if(canMoveTo(newLocation) && checkLineOfSight(getLocation(), newLocation)){
            super.moveTo(newLocation);
        }else{
            System.out.println("Invalid move. Try Again");
        }
    }
}
