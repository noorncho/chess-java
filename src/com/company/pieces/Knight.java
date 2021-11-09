package com.company.pieces;

import com.company.Game;
import com.company.Location;

public class Knight extends ChessPiece {

    public Knight(String owner, Location initialLocation, Game game)  {
        super("Knight", "N", owner, initialLocation, game);
    }

    public boolean canMoveTo(Location newLocation){
        int y = newLocation.getRow();
        int x = newLocation.getCol();
        int row = getLocation().getRow();
        int col = getLocation().getCol();


        if(x >= 0 && x <= 7 && y >= 0 && y <= 7){ // The Location has to be in the board

            /*Makes sure that the piece is moving correctly as according to the rules of chess*/
            if(((y == row - 2 || y == row + 2) && (x == col - 1 || x == col + 1) )||
                    ((y == row - 1 || y == row + 1) && (x == col - 2 || x == col + 2))){

                return true;

            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void moveTo(Location newLocation){
        if(canMoveTo(newLocation)){
            super.moveTo(newLocation);
        }else{
            System.out.println("Invalid Move. Try Again.");
        }
    }
}
