package org.example;

import java.time.LocalDate;
import java.util.List;

public class Eagle extends Animal{
    private int wingspan;
    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, double weight, int height, int wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }
    public String  getTheHighest(List<Eagle> eagles) {
        int highest=0;
        String name="";
        for (int i = 0; i < eagles.size()-1; i++) {
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
    public String getTheShortest(List<Eagle> eagles) {
        int shortest=1000;
        String name="";
        for (int i = 0; i < eagles.size()-1; i++) {
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
    public String getTheHeaviest(List<Eagle> eagles) {
        double heaviest=0.0;
        String name="";
        for (int i = 0; i < eagles.size()-1; i++) {
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
    public String getTheLightest(List<Eagle> eagles) {
        double lightest=1000.0;
        String name="";
        for (int i = 0; i < eagles.size()-1; i++) {
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
    public Eagle getGreaterWingspan(List<Eagle> eagles){
        Eagle wings = eagles.listIterator().next();
        int taillong= 0;
        for (int i = 0; i < eagles.size()-1; i++) {
            if(taillong < eagles.get(i).getWingspan() || taillong< eagles.get(i+1).getWingspan()) {
                if (eagles.get(i).getWingspan() > eagles.get(i + 1).getWingspan()) {
                    taillong=eagles.get(i).getWingspan();
                    wings = eagles.get(i);
                } else {
                    taillong=eagles.get(i+1).getWingspan();
                    wings = eagles.get(i + 1);
                }
            }
        }return wings;
    }
    public int getWingspan() {
        return wingspan;
    }
    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }
    @Override
    public String toString() {
        return "Eagle{" +
                "name='" + super.getName() + '\'' +
                ", favoriteFood='" + super.getFavoriteFood() + '\'' +
                ", age=" + super.getAge() +
                ", entryDate=" + super.getEntryDate() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", wingspan=" + wingspan +
                '}';
    }
}
