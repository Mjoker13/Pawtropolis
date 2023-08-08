package org.example;

public class Main {
    public static void main(String[] args) {

        ZooController zooController= new ZooController();
        zooController.createAnimals();
        System.out.println(zooController.getAnimals());


        // operation
        System.out.println(zooController.getTheHighestTiger());
        System.out.println(zooController.getTheShortestTiger());
        System.out.println(zooController.getTheHeaviestTiger());
        System.out.println(zooController.getTheLightestTiger());
        System.out.println("-----------------------------------------------------");
        System.out.println(zooController.getTheHighestEagle());
        System.out.println(zooController.getTheShortestEagle());
        System.out.println(zooController.getTheHeaviestEagle());
        System.out.println(zooController.getTheLightestEagle());
        System.out.println("-----------------------------------------------------");
        System.out.println(zooController.getTheHighestLion());
        System.out.println(zooController.getTheShortestLion());
        System.out.println(zooController.getTheHeaviestLion());
        System.out.println(zooController.getTheLightestLion());
        System.out.println("-----------------------------------------------------");
        System.out.println(zooController.getLongestTail());
        System.out.println("-----------------------------------------------------");
        System.out.println(zooController.getGreaterWingspan());
    }
}