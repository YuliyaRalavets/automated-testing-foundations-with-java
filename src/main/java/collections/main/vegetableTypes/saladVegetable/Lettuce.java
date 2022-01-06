package collections.main.vegetableTypes.saladVegetable;

import collections.main.vegetableTypes.SaladVegetable;

public class Lettuce extends SaladVegetable {

    public Lettuce(double weight){
        super(15, weight);
    }

    @Override
    public String getName() {
        return "Lettuce";
    }
}