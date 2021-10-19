package collections.optional.main.vegetable.saladVegetable;

import collections.optional.main.vegetable.Vegetable;

abstract public class SaladVegetable extends Vegetable {

    private String category;

    public SaladVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Salad vegetable";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}