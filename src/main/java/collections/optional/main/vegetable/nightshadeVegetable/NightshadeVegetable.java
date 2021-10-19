package collections.optional.main.vegetable.nightshadeVegetable;

import collections.optional.main.vegetable.Vegetable;

abstract public class NightshadeVegetable extends Vegetable {

    private String category;

    public NightshadeVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Nightshade vegetable";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}