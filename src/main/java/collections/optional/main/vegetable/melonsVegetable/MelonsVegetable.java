package collections.optional.main.vegetable.melonsVegetable;

import collections.optional.main.vegetable.Vegetable;

abstract public class MelonsVegetable extends Vegetable {

    private String category;

    public MelonsVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Melons vegetable";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}