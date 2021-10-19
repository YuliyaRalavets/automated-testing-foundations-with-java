package collections.optional.main.vegetable.rootVegetable;

import collections.optional.main.vegetable.Vegetable;

abstract public class RootVegetable extends Vegetable {

    private String category;

    public RootVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Root vegetable";
    }

    @Override
    public String getCategory() {
        return category;
    }

    public abstract String getName();
}
