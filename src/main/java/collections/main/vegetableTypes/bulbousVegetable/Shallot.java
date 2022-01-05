package collections.main.vegetableTypes.bulbousVegetable;

import collections.main.vegetableTypes.BulbousVegetable;

public class Shallot extends BulbousVegetable {

    public Shallot(double weight){
        super(72, weight);
    }

    @Override
    public String getName() {
        return "Shallot";
    }
}
