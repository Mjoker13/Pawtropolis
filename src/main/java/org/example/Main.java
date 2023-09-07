package org.example;

import org.example.Domain.Eagle;
import org.example.Domain.Lion;
import org.example.Domain.Tiger;
import org.example.Domain.ZooController;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ZooController zooController= new ZooController();
        System.out.println(zooController.getAnimals());

        // operation
        System.out.println("The TALLEST tiger is: " + zooController.getHighestAnimalByClass(Tiger.class).getName() + " and its height is: " + zooController.getHighestAnimalByClass(Tiger.class).getHeight() + " cm");
        System.out.println("The SHORTEST tiger is: " + zooController.getShortestAnimalByClass(Tiger.class).getName() + " and its height is: " + zooController.getShortestAnimalByClass(Tiger.class).getHeight() + " cm");
        System.out.println("The HEAVIEST tiger is: " + zooController.getHeaviestAnimalByClass(Tiger.class).getName() + " and its weight is: " + zooController.getHeaviestAnimalByClass(Tiger.class).getWeight() + " kg");
        System.out.println("The LIGHTEST tiger is:" + zooController.getLightestAnimalByClass(Tiger.class).getName() + " and its weight is: " + zooController.getLightestAnimalByClass(Tiger.class).getWeight() + " kg");
        System.out.println("-----------------------------------------------------");
        System.out.println("The TALLEST lion is: " + zooController.getHighestAnimalByClass(Lion.class).getName() + " and its height is: " + zooController.getHighestAnimalByClass(Lion.class).getHeight()+ " cm");
        System.out.println("The SHORTEST lion is: " + zooController.getShortestAnimalByClass(Lion.class).getName() + " and its height is: " + zooController.getShortestAnimalByClass(Lion.class).getHeight()+ " cm");
        System.out.println("The HEAVIEST lion is: " + zooController.getHeaviestAnimalByClass(Lion.class).getName() + " and its weight is: " + zooController.getHeaviestAnimalByClass(Lion.class).getWeight()+ " kg");
        System.out.println("The LIGHTEST lion is: " + zooController.getLightestAnimalByClass(Lion.class).getName() + " and its weight is: " + zooController.getLightestAnimalByClass(Lion.class).getWeight()+ " kg");
        System.out.println("-----------------------------------------------------");
        System.out.println("The TALLEST eagle is: " + zooController.getHighestAnimalByClass(Eagle.class).getName() + " and its height is: " + zooController.getHighestAnimalByClass(Eagle.class).getHeight()+ " cm");
        System.out.println("The SHORTEST eagle is: " + zooController.getShortestAnimalByClass(Eagle.class).getName() + " and its height is: " + zooController.getShortestAnimalByClass(Eagle.class).getHeight()+ " cm");
        System.out.println("The HEAVIEST eagle is: " + zooController.getHeaviestAnimalByClass(Eagle.class).getName() + " and its weight is: " + zooController.getHeaviestAnimalByClass(Eagle.class).getWeight()+ " kg");
        System.out.println("The LIGHTEST eagle is: " + zooController.getLightestAnimalByClass(Eagle.class).getName() + " and its weight is: " + zooController.getLightestAnimalByClass(Eagle.class).getWeight()+ " kg");
        System.out.println("-----------------------------------------------------");
        System.out.println("The animal with longest tail is: " + zooController.getLongestTail().getName() + " and its tail is :" + zooController.getLongestTail().getTailLength()+ " cm");
        System.out.println("-----------------------------------------------------");
        System.out.println("The animal with greater wingspan is: " + zooController.getWidestWingspan().getName() + " and its tail is :" + zooController.getWidestWingspan().getWingspan()+ " cm");
    }
}