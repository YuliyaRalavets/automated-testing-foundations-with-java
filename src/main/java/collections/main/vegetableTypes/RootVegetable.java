package collections.main.vegetableTypes;

abstract public class RootVegetable extends Vegetable {

    private String category;

    public RootVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Root vegetableTypes";
    }

    @Override
    public String getCategory() {
        return category;
    }

    public abstract String getName();
}
