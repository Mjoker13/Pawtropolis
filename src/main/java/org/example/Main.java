package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // list of animals into the zoo
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
        intoTheZoo.add(olimpia);
        intoTheZoo.add(bianca);
        intoTheZoo.add(gigi);

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

        Tiger t = tigers.listIterator().next();
        Lion l = lions.listIterator().next();
        Eagle e = eagles.listIterator().next();

        // operation
        System.out.println(t.getTheHighest(tigers));
        System.out.println(t.getTheShortest(tigers));
        System.out.println(t.getTheHeaviest(tigers));
        System.out.println(t.getTheLightest(tigers));
        System.out.println("----------------------------------------");
        System.out.println(e.getTheHighest(eagles));
        System.out.println(e.getTheShortest(eagles));
        System.out.println(e.getTheHeaviest(eagles));
        System.out.println(e.getTheLightest(eagles));
        System.out.println("----------------------------------------");
        System.out.println(l.getTheHighest(lions));
        System.out.println(l.getTheShortest(lions));
        System.out.println(l.getTheHeaviest(lions));
        System.out.println(l.getTheLightest(lions));
        System.out.println("----------------------------------------");
        if(t.getLongestTail(tigers).getTailLength() > l.getLongestTail(lions).getTailLength()){
            System.out.println("The animal with longest tail is: " + t.getLongestTail(tigers).getName() + " and its tail is :" + t.getLongestTail(tigers).getTailLength());
        }else {
            System.out.println("The animal with longest tail is: " + l.getLongestTail(lions).getName() + " and its tail is :" + l.getLongestTail(lions).getTailLength());
        }
        System.out.println("----------------------------------------");
        System.out.println("The animal with greater wingspan is: " + e.getGreaterWingspan(eagles).getName()+ " and its wingspan is :" + e.getGreaterWingspan(eagles).getWingspan());
    }
}