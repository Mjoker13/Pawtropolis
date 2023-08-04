package org.example;

import java.time.LocalDate;
import java.util.List;

public class Lion extends Animal{
    private int tailLength;
    public Lion() {
    }
    public Lion(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }
    //TODO sfruttare meglio la riusabilità del codice
    public String  getTheHighest(List<Lion> lions) {
        int highest=0;
        String name="";
        for (int i = 0; i < lions.size()-1; i++) {
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
    public String getTheShortest(List<Lion> lions) {
        int shortest=1000;
        String name="";
        for (int i = 0; i < lions.size()-1; i++) {
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
    public String getTheHeaviest(List<Lion> lions) {
        double heaviest=0.0;
        String name="";
        for (int i = 0; i < lions.size()-1; i++) {
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
    public String getTheLightest(List<Lion> lions) {
        double lightest=1000.0;
        String name="";
        for (int i = 0; i < lions.size()-1; i++) {
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
    public Lion getLongestTail(List<Lion> lions){
        Lion tail = new Lion();
        int taillong= 0;
        for (int i = 0; i < lions.size()-1; i++) {
            if(taillong < lions.get(i).getTailLength() || taillong< lions.get(i+1).getTailLength()) {
                if (lions.get(i).getTailLength() > lions.get(i + 1).getTailLength()) {
                    taillong=lions.get(i).getTailLength();
                    tail = lions.get(i);
                } else {
                    taillong=lions.get(i+1).getTailLength();
                    tail = lions.get(i + 1);
                }
            }
        }return tail;
    }
    public int getTailLength() {
        return tailLength;
    }
    public void setTailLenght(int tailLength) {
        this.tailLength = tailLength;
    }
    @Override
    public String toString() {
        return "Lion{" +
                "tailLength=" + tailLength +
                '}';
    }
}
