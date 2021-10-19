package collections.main.vegetable.cabbageVegetable;

import collections.main.vegetable.Vegetable;

abstract public class CabbageVegetable extends Vegetable {

    private String category;

    public CabbageVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Cabbage vegetable";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}