package org.wahlzeit.model;

public class Rabbit {

    private String name;
    private int size;
    private short age;
    private int id;

    private static int currentId;

    private RabbitType type = null;


    public Rabbit(RabbitType rabbitType){
        type = rabbitType;
        id = currentId;
        currentId++;
    }


    public RabbitType getType(){
        return type;
    }


    public int getId(){
     return id;
    }



}
