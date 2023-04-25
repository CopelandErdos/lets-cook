package edu.berkeley.letscook;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;

public class DishTest {

    static Set<Ingredient> availableIngredients = new HashSet<>();

    static Ingredient fish = new Ingredient();
    static Ingredient potato = new Ingredient();

    static Dish chips = new Dish();
    static Dish fishAndChips = new Dish();


    static {
        availableIngredients.add(potato);
        chips.addIngredient(potato);
        fishAndChips.addIngredient(fish);
        fishAndChips.addIngredient(potato);
    }

    @Test
    public void canMakeChips() {
        assertTrue(chips.canMake(availableIngredients));
    }

    @Test
    public void cannotMakeFishAndChips() {
        assertFalse(fishAndChips.canMake(availableIngredients));
    }
}