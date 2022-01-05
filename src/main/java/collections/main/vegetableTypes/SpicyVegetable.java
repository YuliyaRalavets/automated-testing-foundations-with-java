package collections.main.vegetableTypes;

abstract public class SpicyVegetable extends Vegetable {

    private String category;

    public SpicyVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Spicy vegetableTypes";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}