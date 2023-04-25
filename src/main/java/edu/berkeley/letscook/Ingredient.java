package edu.berkeley.letscook;

// understands the properties of each ingredient
public class Ingredient {
    private final double cost;

    public Ingredient(double cost) {
        this.cost = cost;
    }

    public double calculateCost(double quantity) {
        return cost * quantity;
    }
}
