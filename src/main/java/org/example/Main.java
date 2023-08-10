package org.example;


public class Main {
    public static void main(String[] args) {



        ZooController zooController= new ZooController();
        System.out.println(zooController.getAnimals());

        // operation
        System.out.println("The TALLEST tiger is: " + zooController.getTheHighestTiger().getName() + " and its height is: " + zooController.getTheHighestTiger().getHeight() + " cm");
        System.out.println("The SHORTEST tiger is: " + zooController.getTheShortestTiger().getName() + " and its height is: " + zooController.getTheShortestTiger().getHeight() + " cm");
        System.out.println("The HEAVIEST tiger is: " + zooController.getTheHeaviestTiger().getName() + " and its weight is: " + zooController.getTheHeaviestTiger().getWeight() + " kg");
        System.out.println("The LIGHTEST tiger is:" + zooController.getTheLightestTiger().getName() + " and its weight is: " + zooController.getTheLightestTiger().getWeight() + " kg");
        System.out.println("-----------------------------------------------------");
        System.out.println("The TALLEST lion is: " + zooController.getTheHighestLion().getName() + " and its height is: " + zooController.getTheHighestLion().getHeight()+ " cm");
        System.out.println("The SHORTEST lion is: " + zooController.getTheShortestLion().getName() + " and its height is: " + zooController.getTheShortestLion().getHeight()+ " cm");
        System.out.println("The HEAVIEST lion is: " + zooController.getTheHeaviestLion().getName() + " and its weight is: " + zooController.getTheHeaviestLion().getWeight()+ " kg");
        System.out.println("The LIGHTEST lion is: " + zooController.getTheLightestLion().getName() + " and its weight is: " + zooController.getTheLightestLion().getWeight()+ " kg");
        System.out.println("-----------------------------------------------------");
        System.out.println("The TALLEST eagle is: " + zooController.getTheHighestEagle().getName() + " and its height is: " + zooController.getTheHighestEagle().getHeight()+ " cm");
        System.out.println("The SHORTEST eagle is: " + zooController.getTheShortestEagle().getName() + " and its height is: " + zooController.getTheShortestEagle().getHeight()+ " cm");
        System.out.println("The HEAVIEST eagle is: " + zooController.getTheHeaviestEagle().getName() + " and its weight is: " + zooController.getTheHeaviestEagle().getWeight()+ " kg");
        System.out.println("The LIGHTEST eagle is: " + zooController.getTheLightestEagle().getName() + " and its weight is: " + zooController.getTheLightestEagle().getWeight()+ " kg");
        System.out.println("-----------------------------------------------------");
        System.out.println("The animal with longest tail is: " + zooController.getLongestTail().getName() + " and its tail is :" + zooController.getLongestTail().getTailLength()+ " cm");
        System.out.println("-----------------------------------------------------");
        System.out.println("The animal with greater wingspan is: " + zooController.getWidestWingspan().getName() + " and its tail is :" + zooController.getWidestWingspan().getWingspan()+ " cm");
    }
}