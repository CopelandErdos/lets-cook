package edu.berkeley.letscook;
import java.util.HashSet;
import java.util.Set;

// understands the ingredients of each dish
public class Dish {

    private final Set<Ingredient> ingredients;

    public Dish() {
        this.ingredients = new HashSet<Ingredient>();
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public boolean canMake(Set<Ingredient> availableIngredients) {
        for (Ingredient ingredient : ingredients) {
            if (!availableIngredients.contains(ingredient)) {
                return false;
            }
        }
        return true;
    }
}
