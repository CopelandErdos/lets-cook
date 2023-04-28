package edu.berkeley.letscook;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// understands the ingredients of each dish
public class Dish {

    private Map<Ingredient, Quantity> ingredients;
    private Method method;

    public Dish(Method method) {
        this.ingredients = new HashMap<Ingredient, Quantity>();
        this.method = method;
    }

    public void addIngredient(Ingredient ingredient, double quantity, Unit unit) {
        this.ingredients.put(ingredient, new Quantity(quantity, unit));
    }

    public boolean canMake(Map<Ingredient, Quantity> availableIngredients) {
        for (Ingredient ingredient : ingredients.keySet()) {
            if (!(availableIngredients.keySet().contains(ingredient)
                    && availableIngredients.get(ingredient).moreThan(ingredients.get(ingredient)))) {
                return false;
            }
        }
        return true;
    }

    private double calculateValue(Function<Ingredient, Double> strategy, Method method, Function<Method, Double> methodStrategy) {
        double totalValue = 0.0;
        Quantity totalQuantity = new Quantity(0, Unit.OZ);
        for (Ingredient ingredient : ingredients.keySet()) {
            totalValue += ingredient.calculateProp(ingredients.get(ingredient), strategy);
            totalQuantity = totalQuantity.add(ingredients.get(ingredient));
        }
        totalValue += method.calculateProp(totalQuantity, methodStrategy);
        return totalValue;
    }


    public double cost() {
        return calculateValue(Ingredient.COST_STRATEGY, method, Method.COST_STRATEGY);
    }

    public double calories() {
        return calculateValue(Ingredient.CALORIE_STRATEGY, method, Method.CALORIE_STRATEGY);
    }

    public double protein() {
        return calculateValue(Ingredient.PROTEIN_STRATEGY, method, Method.PROTEIN_STRATEGY);
    }

    public double carbohydrate() {
        return calculateValue(Ingredient.CARBOHYDRATE_STRATEGY, method, Method.CARBOHYDRATE_STRATEGY);
    }

    public double fat() {
        return calculateValue(Ingredient.FAT_STRATEGY, method, Method.FAT_STRATEGY);
    }

}
