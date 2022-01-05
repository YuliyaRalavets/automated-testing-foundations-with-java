package collections.main.vegetableTypes.nightshadeVegetable;

import collections.main.vegetableTypes.NightshadeVegetable;

public class ChiliPepper extends NightshadeVegetable {
    public ChiliPepper(double weight){
        super(40, weight);
    }

    @Override
    public String getName() {
        return "Chili pepper";
    }
}