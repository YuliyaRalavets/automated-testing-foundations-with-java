package collections.main.vegetableTypes.tuberVegetable;

import collections.main.vegetableTypes.TuberVegetable;

public class SweetPotato extends TuberVegetable {

    public SweetPotato(double weight){
        super(86, weight);
    }

    @Override
    public String getName() {
        return "Sweet potato";
    }
}