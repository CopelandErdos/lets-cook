package edu.berkeley.letscook;
import java.util.HashMap;
import java.util.Map;

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

    public double cost() {
        double totalCost = 0.0;
        for (Ingredient ingredient : ingredients.keySet()) {
            totalCost += ingredient.calculateCost(ingredients.get(ingredient));
        }
        return totalCost;
    }
}
