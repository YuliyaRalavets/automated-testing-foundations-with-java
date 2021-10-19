package collections.main.vegetable.tuberVegetable;

import collections.main.vegetable.Vegetable;

abstract public class TuberVegetable extends Vegetable {

    private String category;

    public TuberVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Tuber vegetable";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}