package collections.main.vegetableTypes;

abstract public class CabbageVegetable extends Vegetable {

    private String category;

    public CabbageVegetable(double kcal, double weight){
        super(kcal, weight);
        category = "Cabbage vegetableTypes";
    }

    public abstract String getName();

    @Override
    public String getCategory() {
        return category;
    }
}