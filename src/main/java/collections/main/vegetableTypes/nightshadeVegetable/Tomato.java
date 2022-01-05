package collections.main.vegetableTypes.nightshadeVegetable;

import collections.main.vegetableTypes.NightshadeVegetable;

public class Tomato extends NightshadeVegetable {

    public Tomato(double weight){
        super(18, weight);
    }

    @Override
    public String getName() {
        return "Tomato";
    }
}