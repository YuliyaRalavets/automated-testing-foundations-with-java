package collections.main.vegetable.rootVegetable;

public class Radish extends RootVegetable{

    public Radish(double weight){
        super(20, weight);
    }

    @Override
    public String getName() {
        return "Radish";
    }
}