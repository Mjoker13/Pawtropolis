package org.example;
import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.List;

public interface ZooController {

    // Tiger management block
    public static String getTheHighestTiger(List<Tiger> tigers) {
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
        return "The TALLEST tiger is: " + name + " and its height is: " + highest;
    }

    public static String getTheShortestTiger(List<Tiger> tigers) {
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
        return "The SHORTEST tiger is: " + name + " and its height is: " + shortest;
    }

    public static String getTheHeaviestTiger(List<Tiger> tigers) {
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
        return "The HEAVIEST tiger is: " + name + " and its weight is: " + heaviest;
    }

    public static String getTheLightestTiger(List<Tiger> tigers) {
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
        return "The LIGHTEST tiger is: " + name + " and its weight is: " + lightest;
    }

    public static Tiger getLongestTailTiger(List<Tiger> tigers) {
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
    }

    // Lion management block
    public static String getTheHighestLion(List<Lion> lions) {
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

    public static String getTheShortestLion(List<Lion> lions) {
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

    public static String getTheHeaviestLion(List<Lion> lions) {
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

    public static String getTheLightestLion(List<Lion> lions) {
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

    public static Lion getLongestTailLion(List<Lion> lions) {
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
    }

    // Eagle management block
    public static String getTheHighestEagle(List<Eagle> eagles) {
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

    public static String getTheShortestEagle(List<Eagle> eagles) {
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

    public static String getTheHeaviestEagle(List<Eagle> eagles) {
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

    public static String getTheLightestEagle(List<Eagle> eagles) {
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

    public static Eagle getGreaterWingspanEagle(List<Eagle> eagles) {
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
    }

    // management other methods
    public static String getLongestTail(List<Animal> animals) {
        List<Tiger> tigers = new ArrayList<>();
        List<Lion> lions = new ArrayList<>();
        for (var a : animals) {
            if (a instanceof Tiger) {
                tigers.add((Tiger) a);
            } else if (a instanceof Lion) {
                lions.add((Lion) a);
            }
        }
        if(ZooController.getLongestTailTiger(tigers).getTailLength() > ZooController.getLongestTailLion(lions).getTailLength()){
            return "The animal with longest tail is: " + ZooController.getLongestTailTiger(tigers).getName() + " and its tail is :" +ZooController.getLongestTailTiger(tigers).getTailLength();
        }else {
            return "The animal with longest tail is: " + ZooController.getLongestTailLion(lions).getName() + " and its tail is :"+ ZooController.getLongestTailLion(lions).getTailLength();
        }
    }
    public static String getGreaterWingspan(List<Animal> animals){
        List<Eagle> eagles = new ArrayList<>();
        for (var a : animals) {
            if (a instanceof Eagle) {
                eagles.add((Eagle) a);
            }
        }
        return "The animal with greater wingspan is: " + ZooController.getGreaterWingspanEagle(eagles).getName()+ " and its wingspan is :" + ZooController.getGreaterWingspanEagle(eagles).getWingspan();
    }
}
