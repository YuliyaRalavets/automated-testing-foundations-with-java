package collections.main.vegetableTypes.bulbousVegetable;

import collections.main.vegetableTypes.BulbousVegetable;

public class Garlic extends BulbousVegetable {

    public Garlic(double weight){
        super(143, weight);
    }

    @Override
    public String getName() {
        return "Garlic";
    }
}
