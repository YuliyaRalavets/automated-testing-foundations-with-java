package collections.main.vegetableTypes.melonsVegetable;

import collections.main.vegetableTypes.MelonsVegetable;

public class Pumpkin extends MelonsVegetable {

    public Pumpkin(double weight){
        super(26, weight);
    }

    @Override
    public String getName() {
        return "Pumpkin";
    }
}
