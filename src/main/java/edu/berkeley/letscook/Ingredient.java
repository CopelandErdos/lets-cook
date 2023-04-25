package edu.berkeley.letscook;

// understands the properties of each ingredient
public class Ingredient {
    private final double cost;
    private final double calorie;
    public Ingredient(double cost, int calorie) {
        this.cost = cost;
        this.calorie = calorie;
    }

    public double calculateCost(double quantity) {
        return cost * quantity;
    }

    public double calculateCalories(double quantity) {
        return calorie * quantity;
    }
}
