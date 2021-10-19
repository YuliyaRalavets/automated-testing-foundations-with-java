package collections.main.salad;

import collections.main.vegetable.Vegetable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Salad{
    private String name;
    private Map<String, Vegetable> map = new HashMap<>();

    public Salad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNewIngredient(Vegetable vegetable) {
        map.merge(vegetable.getName(), vegetable, (oldV, newV) -> {
            newV.setWeight(newV.getWeight() + oldV.getWeight());
            return newV;
        });
    }

    public void showAllIngredient(){
        System.out.println("The salad " + getName()+ " consist of:");
        for( Map.Entry<String, Vegetable> v : map.entrySet()){
            System.out.println(v.getValue());
        }
        System.out.println("Total salad calories: " + totalSaladCalories());
    }

    public double totalSaladCalories(){
        double calories = 0.0;
        for(Map.Entry<String, Vegetable> v : map.entrySet()){
            calories += v.getValue().totalVegetableCalories();
        }
        return calories;
    }

    public void sortByWeight(){
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Vegetable::getWeight)))
                .forEach(a -> System.out.println(a.getValue()));
    }

    public void sortByKcal(){
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Vegetable::getKcal)))
                .forEach(a -> System.out.println(a.getValue()));
    }

    public void sortByTotalVegetableKcal(){
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Vegetable::totalVegetableCalories)))
                .forEach(a -> System.out.println(a.getValue()));
    }

    public void findVegetableByKcal(double lowerKcal,double upperKcal){
        Map<String, Vegetable> vegetableByKcal = new HashMap<>();
        for( Map.Entry<String, Vegetable> v : map.entrySet()){
            if(v.getValue().getKcal() >= lowerKcal && v.getValue().getKcal() <= upperKcal){
                vegetableByKcal.put(v.getKey(), v.getValue());
            }
        }
        for( Map.Entry<String, Vegetable> v : vegetableByKcal.entrySet()){
            System.out.println(v.getValue());
        }
    }
}