package collections.main.vegetable.rootVegetable;

public class Carrot extends RootVegetable {

    public Carrot(double weight){
        super(32, weight);
    }

    @Override
    public String getName() {
        return "Carrot";
    }
}
