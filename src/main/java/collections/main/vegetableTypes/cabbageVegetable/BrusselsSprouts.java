package collections.main.vegetableTypes.cabbageVegetable;

import collections.main.vegetableTypes.CabbageVegetable;

public class BrusselsSprouts extends CabbageVegetable {

    public BrusselsSprouts(double weight){
        super(43, weight);
    }

    @Override
    public String getName() {
        return "Brussels sprouts";
    }
}
