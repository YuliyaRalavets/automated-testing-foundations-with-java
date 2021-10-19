package collections.optional.main.vegetable.spicyVegetable;

public class Oregano extends SpicyVegetable{

    public Oregano(double weight){
        super(25, weight);
    }

    @Override
    public String getName() {
        return "Oregano";
    }
}