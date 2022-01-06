package collections.main.vegetableTypes;

abstract public class NightshadeVegetable extends Vegetable {

    private String category;

    public NightshadeVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Nightshade vegetableTypes";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}