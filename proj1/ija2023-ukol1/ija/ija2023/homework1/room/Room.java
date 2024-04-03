package ija.ija2023.homework1.room;

import ija.ija2023.homework1.common.Environment;
import ija.ija2023.homework1.common.Obstacle;
import ija.ija2023.homework1.common.Position;
import ija.ija2023.homework1.common.Robot;

public class Room implements Environment {
        private final int rows;
        private final int cols;

        private final Object[][] grid;

        private Room(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;

            this.grid = new Object[rows][cols];

        }

        public static Room create(int rows, int cols) {
            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Rozmery miestnosti musia byt vacsie ako 0.");
            }
            return new Room(rows, cols);
        }

    @Override
    public boolean addRobot(Robot robot) {
        Position pos = robot.getPosition();
        if (!containsPosition(pos) || robotAt(pos) || obstacleAt(pos)) {
            return false;
        }
        grid[pos.getRow()][pos.getCol()] = robot;
        return true;
    }

    @Override
    public boolean createObstacleAt(int row, int col) {
        Position pos = new Position(row, col);
        if(!containsPosition(pos)) {
            return false;
        }
        grid[row][col] = new Obstacle(this, pos);
        return true;
    }

    @Override
    public boolean obstacleAt(int row, int col) {
        if(containsPosition(new Position(row, col))){
            Object obj = grid[row][col];
            return obj instanceof Obstacle;
        }
        return false;
    }

    @Override
    public boolean containsPosition(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    @Override
    public boolean obstacleAt(Position p) {
        return obstacleAt(p.getRow(), p.getCol());
    }

    @Override
    public boolean robotAt(Position p) {
        if(containsPosition(p)){
            return grid[p.getRow()][p.getCol()] instanceof Robot;
        }
        return false;
    }

}

