package ija.ija2023.homework1.common;

public class Obstacle{

    private final Environment env;
    private final Position pos;

    public Obstacle(Environment env, Position pos){
        this.env = env;
        this.pos = pos;
    }

    public Position getPosition(){
        return pos;
    }

}
