package com.company.pieces;

import com.company.Game;
import com.company.Location;

public class Bishop extends ChessPiece{

    public Bishop(String owner, Location initialLocation, Game game) {
        super("Bishop", "B", owner, initialLocation, game);
    }

    public Boolean canMoveTo(Location newLocation){
        int newRow = newLocation.getRow();
        int newCol = newLocation.getCol();
        int currentRow = this.getLocation().getRow();
        int currentCol = this.getLocation().getCol();
        if (this.getGame().getChessBoard().getPieceAt(newLocation) == null && newLocation.isValid()){
            //New location should not have same column or row as current location
            if(newCol == currentCol || newRow == currentRow) return false;
            if(Math.abs(newCol - currentCol) == Math.abs(newRow - currentCol)) return true;
            else return false;
        }
        return false;
    }

    public void moveTo(Location newLocation){
        if(canMoveTo(newLocation) && checkLineOfSight(getLocation(), newLocation)){
            super.moveTo(newLocation);
        }else{
            System.out.println("Invalid Move. Try again");
        }
    }
}
