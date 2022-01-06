package collections.main.vegetableTypes.spicyVegetable;

import collections.main.vegetableTypes.SpicyVegetable;

public class Dill extends SpicyVegetable {

    public Dill(double weight){
        super(43, weight);
    }

    @Override
    public String getName() {
        return "Dill";
    }
}
