package collections.main.vegetableTypes.melonsVegetable;

import collections.main.vegetableTypes.MelonsVegetable;

public class Squash extends MelonsVegetable {

    public Squash(double weight){
        super(16, weight);
    }

    @Override
    public String getName() {
        return "Squash";
    }
}
