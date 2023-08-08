package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooController {
    private List<Animal> animals = new ArrayList<>();
    public ZooController() {
    }
    public ZooController(List<Animal> animals) {
        this.animals = new ArrayList<>();
    }
    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
    public  void addAnimalList(List<Animal> animals){
        this.animals.addAll(animals);
    }
    public void removeAnimal(Animal animal){
        this.animals.remove(animal);
    }
    /*public void createAnimal(){
        String name;
        String favoriteFood;
        int age;
        LocalDate entryDate;
        double weight;
        int height;
        int tailLength;
        int wingspan;
        String scan = "";
        Scanner scanner= new Scanner(System.in);
        System.out.println("You want to create a new animal? yes/no ");
        scan = scanner.nextLine();
        if(scan.contains("yes")){
            System.out.println("Insert a name ");
            name= scanner.nextLine();
            System.out.println("Insert a favorite food ");
            favoriteFood= scanner.nextLine();
            System.out.println("Insert a age ");
            age= Integer.parseInt(scanner.nextLine());
            System.out.println("Insert a entry Date ");
            entryDate= LocalDate.parse(scanner.nextLine());
            System.out.println("Insert a weight ");
            weight= Double.parseDouble(scanner.nextLine());
            System.out.println("Insert a height ");
            height= Integer.parseInt(scanner.nextLine());
            System.out.println("This animal have a tail? yes/no");
            scan = scanner.nextLine();
            if(scan.contains("yes")){
                System.out.println("Insert a tailLength ");
                tailLength= Integer.parseInt(scanner.nextLine());
                AnimalsWithTail animalsWithTail= new AnimalsWithTail(name,favoriteFood,age,entryDate,weight,height,tailLength) {};
                animals.add(animalsWithTail);
            } else if (scan.contains("no")) {
                System.out.println("This animal have a wingspan? yes/no");
                scan= scanner.nextLine();
                if(scan.contains("yes")){
                    System.out.println("Insert a wingspan ");
                    wingspan= Integer.parseInt(scanner.nextLine());
                    AnimalsWithWings animalsWithWings = new AnimalsWithWings(name,favoriteFood,age,entryDate,weight,height,wingspan) {};
                    animals.add(animalsWithWings);
                }
            }
        }
    }*/ // create animal wrong

    public void createAnimals(){

        LocalDate dateSherkan = LocalDate.of(2012,8,20);
        LocalDate dateTigro = LocalDate.of(2018,12,02);
        Tiger sherkan = new Tiger("Sherkan","man",13,dateSherkan,78.5,96,22);
        Tiger tigro = new Tiger("Tigro","honey",8,dateTigro,86.5,95,30);
        Tiger iris = new Tiger("Iris","gazelles",8,dateTigro,82.5,89,45);

        LocalDate dateSimba= LocalDate.of(1994,8,03);
        LocalDate dateAlex= LocalDate.of(1982,10,05);
        Lion simba = new Lion("Simba","insect",12,dateSimba,85,120,35);
        Lion alex = new Lion("Alex","gazelles",18,dateAlex,87,115,28);
        Lion nala = new Lion("Nala","gazelles",15,dateAlex,82,108,49);

        LocalDate dateOlimpia= LocalDate.of(2008,9,13);
        LocalDate dateBianca= LocalDate.of(2000,3,22);
        Eagle olimpia = new Eagle("Olimpia","fish",22,dateOlimpia,20,70,90);
        Eagle bianca = new Eagle("Bianca","rubbit",18,dateBianca,26,68,116);
        Eagle gigi = new Eagle("Gigi","rubbit",15,dateBianca,25,62,98);
        Eagle teresa = new Eagle("Teresa","rubbit",15,dateOlimpia,30,82,108);

        animals.add(sherkan);
        animals.add(tigro);
        animals.add(simba);
        animals.add(alex);
        animals.add(nala);
        animals.add(olimpia);
        animals.add(bianca);
        animals.add(gigi);
        animals.add(teresa);
    }

    // getter & setter
    public List<Animal> getAnimals() {
        return animals;
    }
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    // Tiger management block
    public String getTheHighestTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Tiger){
                tigers.add((Tiger) a);
            }
        }
        int highest = 0;
        String name = "";
        for (int i = 0; i < tigers.size() - 1; i++) {
            if (highest < tigers.get(i).getHeight() || highest < tigers.get(i + 1).getHeight()) {
                if (tigers.get(i).getHeight() > tigers.get(i + 1).getHeight()) {
                    highest = tigers.get(i).getHeight();
                    name = tigers.get(i).getName();
                } else {
                    highest = tigers.get(i + 1).getHeight();
                    name = tigers.get(i + 1).getName();
                }
            }
        }
        return "The TALLEST tiger is: " + name + " and its height is: " + highest +" cm";
    }
    public  String getTheShortestTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Tiger){
                tigers.add((Tiger) a);
            }
        }
        int shortest = 100000;
        String name = "";
        for (int i = 0; i < tigers.size() - 1; i++) {
            if (shortest > tigers.get(i).getHeight() || shortest > tigers.get(i + 1).getHeight()) {
                if (tigers.get(i).getHeight() < tigers.get(i + 1).getHeight()) {
                    shortest = tigers.get(i).getHeight();
                    name = tigers.get(i).getName();
                } else {
                    shortest = tigers.get(i + 1).getHeight();
                    name = tigers.get(i + 1).getName();
                }
            }
        }
        return "The SHORTEST tiger is: " + name + " and its height is: " + shortest+ " cm";
    }
    public String getTheHeaviestTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Tiger){
                tigers.add((Tiger) a);
            }
        }
        double heaviest = 0.0;
        String name = "";
        for (int i = 0; i < tigers.size() - 1; i++) {
            if (heaviest < tigers.get(i).getWeight() || heaviest < tigers.get(i + 1).getWeight()) {
                if (tigers.get(i).getWeight() > tigers.get(i + 1).getWeight()) {
                    heaviest = tigers.get(i).getWeight();
                    name = tigers.get(i).getName();
                } else {
                    heaviest = tigers.get(i + 1).getWeight();
                    name = tigers.get(i + 1).getName();
                }
            }
        }
        return "The HEAVIEST tiger is: " + name + " and its weight is: " + heaviest + " kg";
    }
    public String getTheLightestTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Tiger){
                tigers.add((Tiger) a);
            }
        }
        double lightest = 1000.0;
        String name = "";
        for (int i = 0; i < tigers.size() - 1; i++) {
            if (lightest > tigers.get(i).getWeight() || lightest > tigers.get(i + 1).getWeight()) {
                if (tigers.get(i).getWeight() < tigers.get(i + 1).getWeight()) {
                    lightest = tigers.get(i).getWeight();
                    name = tigers.get(i).getName();
                } else {
                    lightest = tigers.get(i + 1).getWeight();
                    name = tigers.get(i + 1).getName();
                }
            }
        }
        return "The LIGHTEST tiger is: " + name + " and its weight is: " + lightest + " kg";
    }
    public Tiger getLongestTailTiger() {
        List<Tiger> tigers = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Tiger){
                tigers.add((Tiger) a);
            }
        }
        Tiger tail = tigers.listIterator().next();
        int taillong = 0;
        for (int i = 0; i < tigers.size() - 1; i++) {
            if (taillong < tigers.get(i).getTailLength() || taillong < tigers.get(i + 1).getTailLength()) {
                if (tigers.get(i).getTailLength() > tigers.get(i + 1).getTailLength()) {
                    taillong = tigers.get(i).getTailLength();
                    tail = tigers.get(i);
                } else {
                    taillong = tigers.get(i + 1).getTailLength();
                    tail = tigers.get(i + 1);
                }
            }
        }
        return tail;
    } // inutilizzato, serve?

    // Lion management block
    public String getTheHighestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Lion){
                lions.add((Lion) a);
            }
        }
        int highest = 0;
        String name = "";
        for (int i = 0; i < lions.size() - 1; i++) {
            if (highest < lions.get(i).getHeight() || highest < lions.get(i + 1).getHeight()) {
                if (lions.get(i).getHeight() > lions.get(i + 1).getHeight()) {
                    highest = lions.get(i).getHeight();
                    name = lions.get(i).getName();
                } else {
                    highest = lions.get(i + 1).getHeight();
                    name = lions.get(i + 1).getName();
                }
            }
        }
        return "The TALLEST lion is: " + name + " and its height is: " + highest;
    }
    public String getTheShortestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Lion){
                lions.add((Lion) a);
            }
        }
        int shortest = 1000;
        String name = "";
        for (int i = 0; i < lions.size() - 1; i++) {
            if (shortest > lions.get(i).getHeight() || shortest > lions.get(i + 1).getHeight()) {
                if (lions.get(i).getHeight() < lions.get(i + 1).getHeight()) {
                    shortest = lions.get(i).getHeight();
                    name = lions.get(i).getName();
                } else {
                    shortest = lions.get(i + 1).getHeight();
                    name = lions.get(i + 1).getName();
                }
            }
        }
        return "The SHORTEST lion is: " + name + " and its height is: " + shortest;
    }
    public String getTheHeaviestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Lion){
                lions.add((Lion) a);
            }
        }
        double heaviest = 0.0;
        String name = "";
        for (int i = 0; i < lions.size() - 1; i++) {
            if (heaviest < lions.get(i).getWeight() || heaviest < lions.get(i + 1).getWeight()) {
                if (lions.get(i).getWeight() > lions.get(i + 1).getWeight()) {
                    heaviest = lions.get(i).getWeight();
                    name = lions.get(i).getName();
                } else {
                    heaviest = lions.get(i + 1).getWeight();
                    name = lions.get(i + 1).getName();
                }
            }
        }
        return "The HEAVIEST lion is: " + name + " and its weight is: " + heaviest;
    }
    public String getTheLightestLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Lion){
                lions.add((Lion) a);
            }
        }
        double lightest = 1000.0;
        String name = "";
        for (int i = 0; i < lions.size() - 1; i++) {
            if (lightest > lions.get(i).getWeight() || lightest > lions.get(i + 1).getWeight()) {
                if (lions.get(i).getWeight() < lions.get(i + 1).getWeight()) {
                    lightest = lions.get(i).getWeight();
                    name = lions.get(i).getName();
                } else {
                    lightest = lions.get(i + 1).getWeight();
                    name = lions.get(i + 1).getName();
                }
            }
        }
        return "The LIGHTEST lion is: " + name + " and its weight is: " + lightest;
    }
    public Lion getLongestTailLion() {
        List<Lion> lions = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Lion){
                lions.add((Lion) a);
            }
        }
        Lion tail = lions.listIterator().next();
        int taillong = 0;
        for (int i = 0; i < lions.size() - 1; i++) {
            if (taillong < lions.get(i).getTailLength() || taillong < lions.get(i + 1).getTailLength()) {
                if (lions.get(i).getTailLength() > lions.get(i + 1).getTailLength()) {
                    taillong = lions.get(i).getTailLength();
                    tail = lions.get(i);
                } else {
                    taillong = lions.get(i + 1).getTailLength();
                    tail = lions.get(i + 1);
                }
            }
        }
        return tail;
    } // inutilizzato, serve?

    // Eagle management block
    public String getTheHighestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Eagle){
                eagles.add((Eagle) a);
            }
        }
        int highest = 0;
        String name = "";
        for (int i = 0; i < eagles.size() - 1; i++) {
            if (highest < eagles.get(i).getHeight() || highest < eagles.get(i + 1).getHeight()) {
                if (eagles.get(i).getHeight() > eagles.get(i + 1).getHeight()) {
                    highest = eagles.get(i).getHeight();
                    name = eagles.get(i).getName();
                } else {
                    highest = eagles.get(i + 1).getHeight();
                    name = eagles.get(i + 1).getName();
                }
            }
        }
        return "The TALLEST eagle is: " + name + " and its height is: " + highest;
    }
    public String getTheShortestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Eagle){
                eagles.add((Eagle) a);
            }
        }
        int shortest = 1000;
        String name = "";
        for (int i = 0; i < eagles.size() - 1; i++) {
            if (shortest > eagles.get(i).getHeight() || shortest > eagles.get(i + 1).getHeight()) {
                if (eagles.get(i).getHeight() < eagles.get(i + 1).getHeight()) {
                    shortest = eagles.get(i).getHeight();
                    name = eagles.get(i).getName();
                } else {
                    shortest = eagles.get(i + 1).getHeight();
                    name = eagles.get(i + 1).getName();
                }
            }
        }
        return "The SHORTEST eagle is: " + name + " and its height is: " + shortest;
    }
    public String getTheHeaviestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Eagle){
                eagles.add((Eagle) a);
            }
        }
        double heaviest = 0.0;
        String name = "";
        for (int i = 0; i < eagles.size() - 1; i++) {
            if (heaviest < eagles.get(i).getWeight() || heaviest < eagles.get(i + 1).getWeight()) {
                if (eagles.get(i).getWeight() > eagles.get(i + 1).getWeight()) {
                    heaviest = eagles.get(i).getWeight();
                    name = eagles.get(i).getName();
                } else {
                    heaviest = eagles.get(i + 1).getWeight();
                    name = eagles.get(i + 1).getName();
                }
            }
        }
        return "The HEAVIEST eagle is: " + name + " and its weight is: " + heaviest;
    }
    public String getTheLightestEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Eagle){
                eagles.add((Eagle) a);
            }
        }
        double lightest = 1000.0;
        String name = "";
        for (int i = 0; i < eagles.size() - 1; i++) {
            if (lightest > eagles.get(i).getWeight() || lightest > eagles.get(i + 1).getWeight()) {
                if (eagles.get(i).getWeight() < eagles.get(i + 1).getWeight()) {
                    lightest = eagles.get(i).getWeight();
                    name = eagles.get(i).getName();
                } else {
                    lightest = eagles.get(i + 1).getWeight();
                    name = eagles.get(i + 1).getName();
                }
            }
        }
        return "The LIGHTEST eagle is: " + name + " and its weight is: " + lightest;
    }
    public Eagle getGreaterWingspanEagle() {
        List<Eagle> eagles = new ArrayList<>();
        for (Animal a: this.animals) {
            if(a instanceof Eagle){
                eagles.add((Eagle) a);
            }
        }
        Eagle wings = eagles.listIterator().next();
        int taillong = 0;
        for (int i = 0; i < eagles.size() - 1; i++) {
            if (taillong < eagles.get(i).getWingspan() || taillong < eagles.get(i + 1).getWingspan()) {
                if (eagles.get(i).getWingspan() > eagles.get(i + 1).getWingspan()) {
                    taillong = eagles.get(i).getWingspan();
                    wings = eagles.get(i);
                } else {
                    taillong = eagles.get(i + 1).getWingspan();
                    wings = eagles.get(i + 1);
                }
            }
        }
        return wings;
    } // inutilizzato, serve?

    // management other methods
    public String getLongestTail() {
        List<AnimalsWithTail> animalsWithTails = new ArrayList<>();
        for (var a : this.animals) {
            if (a instanceof AnimalsWithTail ) {
                animalsWithTails.add((AnimalsWithTail) a);
            }
        }
        ZooController zooController= new ZooController(animals);
        AnimalsWithTail longestTail= animalsWithTails.listIterator().next();
        for (int i = 0; i < animalsWithTails.size()-1; i++) {
            if(longestTail.getTailLength() < animalsWithTails.get(i).getTailLength() || longestTail.getTailLength() < animalsWithTails.get(i+1).getTailLength() )
                if(animalsWithTails.get(i).getTailLength() > animalsWithTails.get(i+1).getTailLength()){
                    longestTail = animalsWithTails.get(i);
                } else if (animalsWithTails.get(i).getTailLength() < animalsWithTails.get(i+1).getTailLength()) {
                    longestTail = animalsWithTails.get(i+1);
                }else {
                    return "More animals have longer tails";
                }
        }
        return "The animal with longest tail is: " + longestTail.getName() + " and its tail is :" + longestTail.getTailLength();
    }
    public String getGreaterWingspan() {
        List<AnimalsWithWings> animalsWithWings = new ArrayList<>();
        for (var a : this.animals) {
            if (a instanceof AnimalsWithWings) {
                animalsWithWings.add((AnimalsWithWings) a);
            }
        }
        ZooController zooController= new ZooController(animals);
        AnimalsWithWings greaterWingspan= animalsWithWings.listIterator().next();
        for (int i = 0; i < animalsWithWings.size()-1; i++) {
            if(greaterWingspan.getWingspan() < animalsWithWings.get(i).getWingspan() || greaterWingspan.getWingspan() < animalsWithWings.get(i+1).getWingspan() )
                if(animalsWithWings.get(i).getWingspan() > animalsWithWings.get(i+1).getWingspan()){
                    greaterWingspan = animalsWithWings.get(i);
                } else if (animalsWithWings.get(i).getWingspan() < animalsWithWings.get(i+1).getWingspan()) {
                    greaterWingspan = animalsWithWings.get(i+1);
                }else {
                    return "More animals have greatest wing span";
                }
        }
        return "The animal with greater wingspan is: " + greaterWingspan.getName() + " and its wingspan is :" + greaterWingspan.getWingspan();
    }

}
