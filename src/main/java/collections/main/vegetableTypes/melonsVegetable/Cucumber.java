package collections.main.vegetableTypes.melonsVegetable;

import collections.main.vegetableTypes.MelonsVegetable;

public class Cucumber extends MelonsVegetable {

    public Cucumber(double weight){
        super(16, weight);
    }

    @Override
    public String getName() {
        return "Cucumber";
    }
}