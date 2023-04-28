package edu.berkeley.letscook;

import java.util.function.Function;

// understands how cooking methods influence the properties of a dish
public enum Method {
    // ratio added based on total weight of the ingredient
    // ingredient(oz) -> calorie(calorie)
    // ingredient(oz) -> fat(gram)
    FRY(1.5,3.8),
    STEW(0.3,0.2),
    BOIL(0,0),
    STEAM(0,0),
    ROAST(0.5,0.5);

    private final double calorieRatio;
    private final double fatRatio;

    Method(double calorieRatio, double fatRatio) {
        this.calorieRatio = calorieRatio;
        this.fatRatio = fatRatio;
    }

    static Function<Method, Double> COST_STRATEGY = method -> 0.0;
    static Function<Method, Double> CALORIE_STRATEGY = method -> method.calorieRatio;
    static Function<Method, Double> PROTEIN_STRATEGY = method -> 0.0;
    static Function<Method, Double> CARBOHYDRATE_STRATEGY = method -> 0.0;
    static Function<Method, Double> FAT_STRATEGY = method -> method.fatRatio;

    double calculateProp(Quantity quantity, Function<Method, Double> methodStrategy) {
        return quantity.multiplyPerUnit(methodStrategy.apply(this));
    }
}
