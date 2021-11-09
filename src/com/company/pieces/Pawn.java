package com.company.pieces;

import com.company.Game;
import com.company.Location;

public class Pawn extends ChessPiece{
    public boolean firstMove;
    public Pawn(String owner, Location initialLocation, Game game) {
        super("Pawn", "P", owner, initialLocation, game);
        firstMove = true;
    }

    public Boolean canMoveTo(Location newLocation){
        if(newLocation.getCol() == getLocation().getCol()){
            if(newLocation.getRow() == getLocation().getRow() + 2 && firstMove){
                firstMove = false;
                return true;
            }
            else if(newLocation.getRow() == getLocation().getRow() + 1){
                firstMove = false;
                return true;
            }
            return false;
        }
        return false;
    }

    public void moveTo(Location newLocation){
        if(canMoveTo(newLocation)){
            super.moveTo(newLocation);
        }else {
            System.out.println("Invalid Move. Try Again");
        }
    }
}
