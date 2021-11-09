package com.company.pieces;

import com.company.Game;
import com.company.Location;

public class Rook extends ChessPiece{
    public Rook(String owner, Location initialLocation, Game game) {
        super("Rook", "R", owner, initialLocation, game);
    }

    public Boolean canMoveTo(Location newLocation){
        int newRow = newLocation.getRow();
        int newCol = newLocation.getCol();
        int currentRow = this.getLocation().getRow();
        int currentCol = this.getLocation().getCol();
        if (this.getGame().getChessBoard().getPieceAt(newLocation) == null && newLocation.isValid()){
            //Moving forward or backwards
            if(newCol == currentCol) return true;

            //Moving left or right
            else if(newRow == currentRow) return true;

            //Any other move
            else return false;
        }
        return false;
    }

    public void moveTo(Location newLocation){
        if(canMoveTo(newLocation) && checkLineOfSight(getLocation(), newLocation)){
            super.moveTo(newLocation);
        }
    }
}
