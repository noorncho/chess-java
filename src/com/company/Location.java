package com.company;

public class Location {
    private int col;
    private int row;

    public Location(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Checks if in bounds of the Chess Board
     * @return
     */
    public boolean isValid(){
        if(col > 7 || col < 0 || row > 7 || row < 0){
            return false;
        }
        return true;
    }
}
