package com.company.pieces;

import com.company.ChessBoard;
import com.company.Game;
import com.company.Location;

public class ChessPiece {
    private String type;
    private String owner;
    protected String id;
    private Game game;
    private Location location;

    public ChessPiece(String type, String id, String owner, Location location , Game game) {
        this.type = type;
        this.owner = owner;
        this.game = game;
        this.location = location;

        if(owner.equals(game.getPlayer1())){
            this.id = id.toUpperCase();
        }else{
            this.id = id.toLowerCase();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void moveTo(Location newLocation){
        if(this.game.getChessBoard().getPieceAt(newLocation) != null && this.game.getChessBoard().getPieceAt(newLocation).getOwner().equals(this.getOwner())){
            System.out.println("You already have a piece at this location. Try Again.");
            return;
        }
        if(newLocation.isValid()){
            int newLocationRow = newLocation.getRow();
            int newLocationCol = newLocation.getCol();

            getGame().getChessBoard().removePiece(getLocation()); // Removes the piece from it current location
            getLocation().setRow(newLocationRow);
            getLocation().setCol(newLocationCol);
            setLocation(newLocation);
            getGame().getChessBoard().placePieceAt(this, newLocation); // Places the piece at the new location

        }else{
            System.out.println("Invalid Location. Try Again");
        }
    }

    protected boolean checkLineOfSight(Location start, Location end){
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();
        ChessBoard board = getGame().getChessBoard();

        //End location is out of bounds of chess board
        if(!end.isValid()) return false;

        //Check horizontally
        if(startRow == endRow){
            if(endCol > startCol){
                for(int i = startCol + 1; i < endCol; i++){
                    if(board.getPieceAt(startRow, i) != null && !board.getPieceAt(startRow, i).getOwner().equalsIgnoreCase(this.getOwner())){
                        System.out.println("No line of sight. Try Again");
                        return false;
                    }//Identify any shadows - square is occupied, by piece that belongs to player and moving
                    // piece is not a knight
                    else if(board.getPieceAt(startRow, i) != null && board.getPieceAt(startRow, i).getOwner().equalsIgnoreCase(this.getOwner())
                            && !(this instanceof Knight)){
                        System.out.println("Shadow identified cannot move. Try Again.");
                        return false;
                    }
                }
                return true;
            }

            if(endCol < startCol){
                for(int i = startCol + 1; i > endCol; i--){
                    if(board.getPieceAt(startRow, i) != null && !board.getPieceAt(startRow, i).getOwner().equalsIgnoreCase(this.getOwner())){
                        System.out.println("No line of sight. Try Again");
                        return false;
                    }//Identify any shadows - square is occupied, by piece that belongs to player and moving
                    // piece is not a knight
                    else if(board.getPieceAt(startRow, i) != null && board.getPieceAt(startRow, i).getOwner().equalsIgnoreCase(this.getOwner())
                            && !(this instanceof Knight)){
                        System.out.println("Shadow identified cannot move. Try Again.");
                        return false;
                    }
                }
                return true;
            }

        }

        //Check vertically
        if(startCol == endCol){
            if(endRow > startRow){
                for(int i = startRow + 1; i < endRow; i++){
                    if(board.getPieceAt(i, startCol) != null && !board.getPieceAt(i, startCol).getOwner().equalsIgnoreCase(this.getOwner())){
                        System.out.println("No line of sight. Try Again");
                        return false;
                    }else if(board.getPieceAt(i, startCol) != null && board.getPieceAt(i, startCol).getOwner().equalsIgnoreCase(this.getOwner())
                            && !(this instanceof Knight)){
                        System.out.println("Shadow identified cannot move. Try Again.");
                        return false;
                    }
                }
                return true;
            }

            if(endRow < startRow){
                for(int i = startRow - 1; i > endRow; i--){
                    if(board.getPieceAt(i, startCol) != null && !board.getPieceAt(i, startCol).getOwner().equalsIgnoreCase(this.getOwner())){
                        System.out.println("No line of sight. Try Again");
                        return false;
                    }else if(board.getPieceAt(i, startCol) != null && board.getPieceAt(i, startCol).getOwner().equalsIgnoreCase(this.getOwner())
                            && !(this instanceof Knight)){
                        System.out.println("Shadow identified cannot move. Try Again.");
                        return false;
                    }
                }
                return true;
            }
        }

        //Check diagonally
        if(Math.abs(startCol - endCol) == Math.abs(startRow - endRow)){
            //top-right diagonal
            if(endCol > startCol && endRow < startRow){
                for (int row = startRow - 1; row >= endRow; row--){
                    for(int col = startCol + 1; col <= endCol; col++){
                        if(Math.abs(startCol - col) == Math.abs(startRow - row)){
                            if(board.getPieceAt(row, col) != null && !board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())){
                                System.out.println("No line of sight. Try Again");
                                return false;
                            }
                            //Identify any shadows - square is occupied, by piece that belongs to player and moving
                            // piece is not a knight
                            else if(board.getPieceAt(row, col) != null && board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())
                                    && !(this instanceof Knight)){
                                System.out.println("Shadow identified cannot move. Try Again.");
                                return false;
                            }
                        }
                    }
                }
                return true;
            }

            //bottom-right diagonal
            if(endCol > startCol && endRow > startRow){
                for (int row = startRow + 1; row <= endRow; row++) {
                    for (int col = startCol + 1; col <= endCol; col++) {
                        if(Math.abs(startCol - col) == Math.abs(startRow - row)){
                            if(board.getPieceAt(row, col) != null && !board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())){
                                System.out.println("No line of sight. Try Again");
                                return false;
                            }else if(board.getPieceAt(row, col) != null && board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())
                                    && !(this instanceof Knight)){
                                System.out.println("Shadow identified cannot move. Try Again.");
                                return false;
                            }
                        }
                    }
                }
                return true;
            }

            //top-left diagonal
            if(endCol < startCol && endRow < startRow){
                for (int row = startRow - 1; row >= endRow; row--) {
                    for (int col = startCol - 1; col >= endCol; col--) {
                        if(Math.abs(startCol - col) == Math.abs(startRow - row)){
                            if(board.getPieceAt(row, col) != null && !board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())){
                                System.out.println("No line of sight. Try Again");
                                return false;
                            }else if(board.getPieceAt(row, col) != null && board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())
                                    && !(this instanceof Knight)){
                                System.out.println("Shadow identified cannot move. Try Again.");
                                return false;
                            }
                        }
                    }
                }
                return true;
            }

            //bottom-left diagonal
            if(endCol < startCol && endRow > startRow){
                for (int row = startRow + 1; row <= endRow; row++) {
                    for (int col = startCol - 1; col >= endCol; col--) {
                        if(Math.abs(startCol - col) == Math.abs(startRow - row)){
                            if(board.getPieceAt(row, col) != null && !board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())){
                                System.out.println("No line of sight. Try Again");
                                return false;
                            }else if(board.getPieceAt(row, col) != null && board.getPieceAt(row, col).getOwner().equalsIgnoreCase(this.getOwner())
                                    && !(this instanceof Knight)){
                                System.out.println("Shadow identified cannot move. Try Again.");
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }

        return false;
    }

    private boolean identifiedShadow(ChessPiece piece, Location location){
        return false;
    }
}
