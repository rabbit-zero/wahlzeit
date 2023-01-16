package org.wahlzeit.model;

import org.junit.Test;

import java.util.HashSet;

public class RabbitTypeTest {

    /**
     *
     */
    @Test
    public void testFunctionality(){

        //hierarchy
        RabbitType testType = new RabbitType("Zwergkaninchen");

        RabbitType testSubType1 = new RabbitType("Loewenkoepfchen");
        RabbitType testSubType2 = new RabbitType("Hermelin");
        RabbitType testSubType3 = new RabbitType("Teddy");

        testType.addSubType(testSubType1);
        testType.addSubType(testSubType2);
        testType.addSubType(testSubType3);

        RabbitType testType2 = new RabbitType("Langhaarkaninchen");
        RabbitType testSubType4 = new RabbitType("Angora");
        testType2.addSubType(testSubType4);

        HashSet<RabbitType> givenTypes = new HashSet<RabbitType>();
        givenTypes.add(testType);
        givenTypes.addAll(testType.getSubTypes());
        givenTypes.add(testType2);
        givenTypes.addAll(testType2.getSubTypes());

        RabbitManager rabbitManager = new RabbitManager(givenTypes);
        rabbitManager.createRabbit("Löwenköpfchen");
        rabbitManager.createRabbit("Angora");
        rabbitManager.createRabbit("Zwergkaninchen");


    }
}
