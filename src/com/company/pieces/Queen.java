package com.company.pieces;

import com.company.Game;
import com.company.Location;

public class Queen extends ChessPiece {
    public Queen(String owner, Location initialLocation, Game game) {
        super("Queen", "Q", owner, initialLocation, game);
    }

    public void moveTo(Location newLocation){
        if(checkLineOfSight(getLocation(),newLocation)){
            super.moveTo(newLocation);
        }else{
            System.out.println("Invalid Move. Try Again.");
        }
    }
}
