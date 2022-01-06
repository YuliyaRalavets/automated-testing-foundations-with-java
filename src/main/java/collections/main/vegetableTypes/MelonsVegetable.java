package collections.main.vegetableTypes;

abstract public class MelonsVegetable extends Vegetable {

    private String category;

    public MelonsVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Melons vegetableTypes";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}