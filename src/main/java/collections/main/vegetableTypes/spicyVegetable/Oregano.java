package collections.main.vegetableTypes.spicyVegetable;

import collections.main.vegetableTypes.SpicyVegetable;

public class Oregano extends SpicyVegetable {

    public Oregano(double weight){
        super(25, weight);
    }

    @Override
    public String getName() {
        return "Oregano";
    }
}