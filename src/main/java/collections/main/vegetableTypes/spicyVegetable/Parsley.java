package collections.main.vegetableTypes.spicyVegetable;

import collections.main.vegetableTypes.SpicyVegetable;

public class Parsley extends SpicyVegetable {

    public Parsley(double weight){
        super(36, weight);
    }

    @Override
    public String getName() {
        return "Parsley";
    }
}
