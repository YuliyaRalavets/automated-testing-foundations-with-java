package collections.main.vegetableTypes.cabbageVegetable;

import collections.main.vegetableTypes.CabbageVegetable;

public class Cauliflower extends CabbageVegetable {

    public Cauliflower(double weight){
        super(25, weight);
    }

    @Override
    public String getName() {
        return "Cauliflower";
    }
}