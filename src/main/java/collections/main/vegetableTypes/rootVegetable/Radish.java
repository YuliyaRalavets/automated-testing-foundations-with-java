package collections.main.vegetableTypes.rootVegetable;

import collections.main.vegetableTypes.RootVegetable;

public class Radish extends RootVegetable {

    public Radish(double weight){
        super(20, weight);
    }

    @Override
    public String getName() {
        return "Radish";
    }
}