package ija.ija2023.homework1.common;

public class Obstacle{

    private Environment env;
    private Position pos;

    public Obstacle(Environment env, Position pos){
        this.env = env;
        this.pos = pos;
    }

    public Position getPosition(){
        return pos;
    }

}
