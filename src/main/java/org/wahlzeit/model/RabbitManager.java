package org.wahlzeit.model;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RabbitManager {


    private static RabbitManager instance = null;

    private HashMap<Integer, Rabbit> rabbits = new HashMap<>();

    private Set<RabbitType> types;

    /**
     *
     * @methodtype constructor
     */
    public RabbitManager(HashSet<RabbitType> givenTypes){
        assert (givenTypes != null);
        types = givenTypes;
    }


    public RabbitType getRabbitType(String typeName){
        assertIsValidRabbitTypeName(typeName);

        for (RabbitType type : types) {
            if (typeName.equals(type.getTypeName())) {
                return type;
            }
        }

        return new RabbitType(typeName);
    }


    public Rabbit createRabbit(String typeName) {
        assertIsValidRabbitTypeName(typeName);
        RabbitType rabbitType = getRabbitType(typeName);
        Rabbit result = rabbitType.createInstance();
        rabbits.put(result.getId(), result);
        return result;
    }

    public void assertIsValidRabbitTypeName(String name){
        assert (name != null);
        assert (!name.equals(""));
    }

}
