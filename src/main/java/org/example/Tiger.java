package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tiger extends Animal {
    private int tailLength;

    public Tiger() {
    }

    public Tiger(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }

    //TODO sfruttare meglio la riusabilità del codice
    public String getTheHighest(List<Tiger> tigers) {
        int highest=0;
        String name="";
        for (int i = 0; i < tigers.size()-1; i++) {
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
    public String getTheShortest(List<Tiger> tigers) {
        int shortest=100000;
        String name="";
        for (int i = 0; i < tigers.size()-1; i++) {
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
    public String getTheHeaviest(List<Tiger> tigers) {
        double heaviest=0.0;
        String name="";
        for (int i = 0; i < tigers.size()-1; i++) {
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
    public String getTheLightest(List<Tiger> tigers) {
        double lightest=1000.0;
        String name="";
        for (int i = 0; i < tigers.size()-1; i++) {
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
    public Tiger getLongestTail(List<Tiger> tigers){
        Tiger tail = new Tiger();
        int taillong= 0;
        for (int i = 0; i < tigers.size()-1; i++) {
            if(taillong < tigers.get(i).getTailLength() || taillong< tigers.get(i+1).getTailLength()) {
                if (tigers.get(i).getTailLength() > tigers.get(i + 1).getTailLength()) {
                    taillong=tigers.get(i).getTailLength();
                    tail = tigers.get(i);
                } else {
                    taillong=tigers.get(i+1).getTailLength();
                    tail = tigers.get(i + 1);
                }
            }
        }return tail;
    }
    public int getTailLength() {
        return tailLength;
    }
    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }
    @Override
    public String toString() {
        return "Tiger{" +
                "tailLength=" + tailLength +
                '}';
    }
}
