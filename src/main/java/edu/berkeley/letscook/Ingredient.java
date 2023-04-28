package edu.berkeley.letscook;
import java.util.function.Function;

// understands the properties of each ingredient
public class Ingredient {

    // ingredientUnit:
    // fish and chicken per lb
    // potato, carrot, onion per item (mid-size item / oz)
    // units: cost-USD, calorie-calorie, protein-gram, carbohydrate-gram, fat-gram
    private final Quantity ingredientUnit;
    private final double cost;
    private final double calorie;
    private final double protein;
    private final double carbohydrate;
    private final double fat;

    public Ingredient(double quantity, Unit unit, double cost, double calorie, double protein, double carbohydrate, double fat) {
        this.ingredientUnit = new Quantity(quantity, unit);
        this.cost = cost;
        this.calorie = calorie;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
    }

    static Function<Ingredient, Double> COST_STRATEGY = ingredient -> ingredient.cost;
    static Function<Ingredient, Double> CALORIE_STRATEGY = ingredient -> ingredient.calorie;
    static Function<Ingredient, Double> PROTEIN_STRATEGY = ingredient -> ingredient.protein;
    static Function<Ingredient, Double> CARBOHYDRATE_STRATEGY = ingredient -> ingredient.carbohydrate;
    static Function<Ingredient, Double> FAT_STRATEGY = ingredient -> ingredient.fat;

    double calculateProp(Quantity quantity, Function<Ingredient, Double> strategy) {
        return quantity.multiplyPerUnit(strategy.apply(this), ingredientUnit);
    }

}
