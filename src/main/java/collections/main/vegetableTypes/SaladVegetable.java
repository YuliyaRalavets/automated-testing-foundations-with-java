package collections.main.vegetableTypes;

abstract public class SaladVegetable extends Vegetable {

    private String category;

    public SaladVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Salad vegetableTypes";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}