package collections.main.vegetable.bulbousVegetable;

import collections.main.vegetable.Vegetable;

abstract public class BulbousVegetable extends Vegetable {

    private String category;

    public BulbousVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Bulbous vegetable";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}
