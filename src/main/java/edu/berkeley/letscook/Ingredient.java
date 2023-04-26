package edu.berkeley.letscook;
import java.util.function.Function;

// understands the properties of each ingredient
public class Ingredient {
    private final double cost;
    private final double calorie;
    private final double protein;

    public Ingredient(double cost, double calorie, double protein) {
        this.cost = cost;
        this.calorie = calorie;
        this.protein = protein;
    }

    static Function<Ingredient, Double> COST_STRATEGY = ingredient -> ingredient.cost;
    static Function<Ingredient, Double> CALORIE_STRATEGY = ingredient -> ingredient.calorie;
    static Function<Ingredient, Double> PROTEIN_STRATEGY = ingredient -> ingredient.protein;

    double calculateProp(double quantity, Function<Ingredient, Double> strategy) {
        return strategy.apply(this) * quantity;
    }

}
