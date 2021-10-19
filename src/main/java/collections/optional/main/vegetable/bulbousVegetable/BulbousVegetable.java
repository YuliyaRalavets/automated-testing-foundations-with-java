package collections.optional.main.vegetable.bulbousVegetable;

import collections.optional.main.vegetable.Vegetable;

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
