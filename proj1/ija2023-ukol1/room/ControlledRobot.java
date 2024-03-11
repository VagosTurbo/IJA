package ija.ija2023.homework1.room;

import ija.ija2023.homework1.common.Environment;
import ija.ija2023.homework1.common.Position;
import ija.ija2023.homework1.common.Robot;

public class ControlledRobot implements Robot {
    private Environment environment;
    private Position position;
    private int current_angle;

    private ControlledRobot(Environment environment, Position position) {
        this.environment = environment;
        this.position = position;
        this.current_angle = 0;
    }

    public static ControlledRobot create(Environment env, Position pos) {
        if(!env.containsPosition(pos) || env.robotAt(pos) || env.obstacleAt(pos)){
            return null;
        }
        else {
            return new ControlledRobot(env, pos);
        }
    }

    public int angle(){
        return current_angle;
    }

    public boolean canMove(){
        Position next = getNextPosition();
        return !environment.obstacleAt(next) && !environment.robotAt(next) && environment.containsPosition(next);
    }

    public Position getPosition(){
        return position;
    }

    public boolean move(){
        if(canMove()){
            position = getNextPosition();
            return true;
        }
        return false;
    }

    public void turn(){
        current_angle = (current_angle + 45) % 360;
    }

    private Position getNextPosition() {
        int dx = 0, dy = 0;
        switch (current_angle) {
            case 0:
                dy = -1;
                break;
            case 45:
                dx = 1;
                dy = -1;
                break;
            case 90:
                dx = 1;
                break;
            case 135:
                dx = 1;
                dy = 1;
                break;
            case 180:
                dy = 1;
                break;
            case 225:
                dx = -1;
                dy = 1;
                break;
            case 270:
                dx = -1;
                break;
            case 315:
                dx = -1;
                dy = -1;
                break;
        }
        int new_x = position.getRow() + dy;
        int new_y = position.getCol() + dx;
        return new Position(position.getRow() + dy, position.getCol() + dx);
    }

}
