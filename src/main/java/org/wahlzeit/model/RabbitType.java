package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RabbitType {

    protected String typeName;
    protected RabbitType superType = null;
    protected Set<RabbitType> subTypes = new HashSet<RabbitType>();


    /**
     *
     * @methodtype construct
     */
    public RabbitType(String name){
        typeName = name;
    }

    /**
     *
     * @methodtype get
     */
    public String getTypeName(){
        return typeName;
    }

    /**
     *
     * @methodtype get
     */
    public RabbitType getSuperType(){
        return superType;
    }

    /**
     *
     * @methodtype get
     */
    public Iterator<RabbitType> getSubTypeIterator(){
        return subTypes.iterator();
    }

    /**
     *
     * @methodtype set
     */
    public void setSuperType(RabbitType rabbitType){
        superType = rabbitType;
    }


    /**
     *
     * @methodtype boolean-query
     */
    public boolean isSubType(){
        return superType != null;
    }


    public void addSubType(RabbitType rabbitType){
        assert (rabbitType != null);
        rabbitType.setSuperType(this);
        subTypes.add(rabbitType);
    }


    public Rabbit createInstance(){
        return new Rabbit(this);
    }

    /**
     *
     * @methodtype boolean-query
     */
    public boolean hasInstance(Rabbit rabbit) {
        assert (rabbit != null);

        if (rabbit.getType() == this)
            return true;

        for (RabbitType type : subTypes) {
            if (type.hasInstance(rabbit)) {
                return true;
            }
        }

        return false;
    }


}


