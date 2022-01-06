package collections.main.vegetableTypes.bulbousVegetable;

import collections.main.vegetableTypes.BulbousVegetable;

public class Leek extends BulbousVegetable {

    public Leek(double weight){
        super(61, weight);
    }

    @Override
    public String getName() {
        return "Leek";
    }
}