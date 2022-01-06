package collections.main.vegetableTypes.nightshadeVegetable;

import collections.main.vegetableTypes.NightshadeVegetable;

public class Pepper extends NightshadeVegetable {
    public Pepper(double weight){
        super(27, weight);
    }

    @Override
    public String getName() {
        return "Pepper";
    }
}