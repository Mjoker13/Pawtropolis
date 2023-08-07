package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // creare un zooController che gestisce le liste ed i metodi degli animali
        // limitare al massimo l'impatto se dovesse entrare qualche altro animale
        // information hiding, incapsulamento, information expert, controller(grasp)

        List<Animal> intoTheZoo = new ArrayList<>();
        // create animals
        LocalDate dateSherkan = LocalDate.of(2012,8,20);
        LocalDate dateTigro = LocalDate.of(2018,12,02);
        Tiger sherkan = new Tiger("Sherkan","man",13,dateSherkan,78.5,83,22);
        Tiger tigro = new Tiger("Tigro","honey",8,dateTigro,86.5,95,30);
        Tiger iris = new Tiger("Iris","gazelles",8,dateTigro,82.5,89,45);
        intoTheZoo.add(sherkan);
        intoTheZoo.add(tigro);
        intoTheZoo.add(iris);

        LocalDate dateSimba= LocalDate.of(1994,8,03);
        LocalDate dateAlex= LocalDate.of(1982,10,05);
        Lion simba = new Lion("Simba","insect",12,dateSimba,85,120,35);
        Lion alex = new Lion("Alex","gazelles",18,dateAlex,87,115,28);
        Lion nala = new Lion("Nala","gazelles",15,dateAlex,82,108,39);
        intoTheZoo.add(simba);
        intoTheZoo.add(alex);
        intoTheZoo.add(nala);

        LocalDate dateOlimpia= LocalDate.of(2008,9,13);
        LocalDate dateBianca= LocalDate.of(2000,3,22);
        Eagle olimpia = new Eagle("Olimpia","fish",22,dateOlimpia,20,70,90);
        Eagle bianca = new Eagle("Bianca","rubbit",18,dateBianca,26,68,86);
        Eagle gigi = new Eagle("Gigi","rubbit",15,dateBianca,25,62,98);
        Eagle teresa = new Eagle("Teresa","rubbit",15,dateOlimpia,30,82,108);
        intoTheZoo.add(olimpia);
        intoTheZoo.add(bianca);
        intoTheZoo.add(gigi);
        intoTheZoo.add(teresa);

        // split the instance of animals into multiple list
        List<Tiger> tigers= new ArrayList<>();
        List<Lion> lions= new ArrayList<>();
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a: intoTheZoo)  {
            if( a instanceof Tiger){
                tigers.add((Tiger) a);
            }else if(a instanceof Lion){
                lions.add((Lion) a);
            }else if(a instanceof Eagle){
                eagles.add((Eagle) a);
            }
        }

        // operation
        //i metodi statici li posso chiamare con la classe stessa (Tiger.metodostatico();)
        System.out.println(ZooController.getTheHighestTiger(tigers));
        System.out.println(ZooController.getTheShortestTiger(tigers));
        System.out.println(ZooController.getTheHeaviestTiger(tigers));
        System.out.println(ZooController.getTheLightestTiger(tigers));
        System.out.println("-----------------------------------------------------");
        System.out.println(ZooController.getTheHighestEagle(eagles));
        System.out.println(ZooController.getTheShortestEagle(eagles));
        System.out.println(ZooController.getTheHeaviestEagle(eagles));
        System.out.println(ZooController.getTheLightestEagle(eagles));
        System.out.println("-----------------------------------------------------");
        System.out.println(ZooController.getTheHighestLion(lions));
        System.out.println(ZooController.getTheShortestLion(lions));
        System.out.println(ZooController.getTheHeaviestLion(lions));
        System.out.println(ZooController.getTheLightestLion(lions));
        System.out.println("-----------------------------------------------------");
        System.out.println(ZooController.getLongestTail(intoTheZoo));
        System.out.println("-----------------------------------------------------");
        System.out.println(ZooController.getGreaterWingspan(intoTheZoo));
    }
}