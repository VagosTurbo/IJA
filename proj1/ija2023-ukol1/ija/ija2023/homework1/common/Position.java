package ija.ija2023.homework1.common;

public class Position {
    private final int row;
    private final int col;

    public Position(int row, int col){
        this.col = col;
        this.row = row;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + row;
        result = 31 * result + col;
        return result;
    }

    public String toString() {
        return "(" + row + ", " + col + ")";
    }

}
