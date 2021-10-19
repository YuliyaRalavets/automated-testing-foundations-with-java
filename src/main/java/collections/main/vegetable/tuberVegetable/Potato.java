package collections.main.vegetable.tuberVegetable;

public class Potato extends TuberVegetable{

    public Potato(double weight){
        super(77, weight);
    }

    @Override
    public String getName() {
        return "Potato";
    }
}