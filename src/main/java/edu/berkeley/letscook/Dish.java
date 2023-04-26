package edu.berkeley.letscook;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// understands the ingredients of each dish
public class Dish {

    private Map<Ingredient, Double> ingredients;

    public Dish() {
        this.ingredients = new HashMap<Ingredient, Double>();
    }

    public void addIngredient(Ingredient ingredient, double quantity) {
        this.ingredients.put(ingredient, quantity);
    }

    public boolean canMake(Map<Ingredient, Double> availableIngredients) {
        for (Ingredient ingredient : ingredients.keySet()) {
            if (!(availableIngredients.keySet().contains(ingredient)
                    && availableIngredients.get(ingredient) >= ingredients.get(ingredient))) {
                return false;
            }
        }
        return true;
    }

    private double calculateValue(Function<Ingredient, Double> strategy) {
        double totalValue = 0.0;
        for (Ingredient ingredient : ingredients.keySet()) {
            totalValue += ingredient.calculateProp(ingredients.get(ingredient), strategy);
        }
        return totalValue;
    }


    public double cost() {
        return calculateValue(Ingredient.COST_STRATEGY);
    }

    public double calories() {
        return calculateValue(Ingredient.CALORIE_STRATEGY);
    }

    public double protein() {
        return calculateValue(Ingredient.PROTEIN_STRATEGY);
    }
}
