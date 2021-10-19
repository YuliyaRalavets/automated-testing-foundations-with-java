package collections.main.vegetable.saladVegetable;

public class Lettuce extends SaladVegetable {

    public Lettuce(double weight){
        super(15, weight);
    }

    @Override
    public String getName() {
        return "Lettuce";
    }
}