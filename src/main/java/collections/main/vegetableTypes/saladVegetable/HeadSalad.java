package collections.main.vegetableTypes.saladVegetable;

import collections.main.vegetableTypes.SaladVegetable;

public class HeadSalad extends SaladVegetable {

    public HeadSalad(double weight){
        super(14, weight);
    }

    @Override
    public String getName() {
        return "Head salad";
    }
}
