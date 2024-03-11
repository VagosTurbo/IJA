package ija.ija2023.homework1.common;

public interface Robot {
    // Returns the current angle of the robot.
    int angle();

    // Checks if the robot can move to the adjacent cell in its current direction.
    boolean canMove();

    // Returns information about the current position of the robot in the environment.
    Position getPosition();

    // Moves the robot to the adjacent cell in its current direction. Returns the result of the action.
    boolean move();

    // Turns the robot by 45 degrees clockwise.
    void turn();
}

