package collections.main.vegetableTypes.cabbageVegetable;

import collections.main.vegetableTypes.CabbageVegetable;

public class Broccoli extends CabbageVegetable {

    public Broccoli(double weight){
        super(25, weight);
    }

    @Override
    public String getName() {
        return "Broccoli";
    }
}