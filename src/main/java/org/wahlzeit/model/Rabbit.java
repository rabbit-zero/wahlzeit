package org.wahlzeit.model;

public class Rabbit {

    private String name;
    private short age;
    private int id;

    private static int currentId;

    private RabbitType type = null;


    /**
     *
     * @methodtype constructor
     */
    public Rabbit(RabbitType rabbitType){
        type = rabbitType;
        id = currentId;
        currentId++;
    }

    /**
     *
     * @methodtype constructor
     */
    public Rabbit(RabbitType rabbitType, String rabbitName, short rabbitAge){
        type = rabbitType;
        name = rabbitName;
        age = rabbitAge;
    }

    /**
     *
     * @methodtype get
     */
    public RabbitType getType(){
        return type;
    }

    /**
     *
     * @methodtype get
     */
    public int getId() { return id; }

    /**
     *
     * @methodtype get
     */
    public String getName() { return name; }

    /**
     *
     * @methodtype get
     */
    public short getAge() { return age; }

    /**
     *
     * @methodtype set
     */
    public void setName(String rabbitName){ name = rabbitName; }

    /**
     *
     * @methodtype set
     */
    public void setAge(short rabbitAge){ age = rabbitAge; }





}
