package collections.main.vegetableTypes.spicyVegetable;

import collections.main.vegetableTypes.SpicyVegetable;

public class Basil extends SpicyVegetable {

    public Basil(double weight){
        super(22, weight);
    }

    @Override
    public String getName() {
        return "Basil";
    }
}