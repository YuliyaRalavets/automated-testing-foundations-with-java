package collections.main.vegetableTypes;

abstract public class TuberVegetable extends Vegetable {

    private String category;

    public TuberVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Tuber vegetableTypes";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}