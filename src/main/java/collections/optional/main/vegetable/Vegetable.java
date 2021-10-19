package collections.optional.main.vegetable;

abstract public class Vegetable {
    private double kcal;
    private double weight;

    public Vegetable(double kcal, double weight) {
        this.kcal = kcal;
        this.weight = weight;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double totalVegetableCalories(){
        return getWeight()*getKcal()/100;
    }

    @Override
    public String toString() {
        return getName() + "(" + getCategory() + ")" + ": "
                + getWeight() + "g.; " + getKcal() + "kcal.per 100g.; " + totalVegetableCalories() + " total calories";
    }

    public abstract String getName();

    public abstract String getCategory();

}
