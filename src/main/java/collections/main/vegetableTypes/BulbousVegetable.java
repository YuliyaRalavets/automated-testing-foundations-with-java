package collections.main.vegetableTypes;

abstract public class BulbousVegetable extends Vegetable {

    private String category;

    public BulbousVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Bulbous vegetableTypes";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}
