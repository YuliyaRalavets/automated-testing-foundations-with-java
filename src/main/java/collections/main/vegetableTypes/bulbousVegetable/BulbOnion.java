package collections.main.vegetableTypes.bulbousVegetable;

import collections.main.vegetableTypes.BulbousVegetable;

public class BulbOnion extends BulbousVegetable {

    public BulbOnion(double weight){
        super(40, weight);
    }

    @Override
    public String getName() {
        return "Bulb onion";
    }
}
