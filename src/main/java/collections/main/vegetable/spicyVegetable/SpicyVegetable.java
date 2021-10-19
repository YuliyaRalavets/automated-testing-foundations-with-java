package collections.main.vegetable.spicyVegetable;

import collections.main.vegetable.Vegetable;

abstract public class SpicyVegetable extends Vegetable {

    private String category;

    public SpicyVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Spicy vegetable";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}