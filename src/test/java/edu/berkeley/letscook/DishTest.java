package edu.berkeley.letscook;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class DishTest {

    static Map<Ingredient, Double> availableIngredients = new HashMap<>();

    static Ingredient fish = new Ingredient();
    static Ingredient potato = new Ingredient();
    static Ingredient chicken = new Ingredient();
    static Ingredient carrot = new Ingredient();
    static Ingredient onion = new Ingredient();
    static Dish chips = new Dish();
    static Dish fishAndChips = new Dish();
    static Dish curryChicken = new Dish();


    static {
        availableIngredients.put(potato, 5.0);
        availableIngredients.put(fish, 1.0);
        availableIngredients.put(chicken, 2.5);
        availableIngredients.put(carrot, 5.0);
        availableIngredients.put(onion, 2.0);

        chips.addIngredient(potato, 1.0);
        fishAndChips.addIngredient(fish, 2.0);
        fishAndChips.addIngredient(potato, 1.0);
        curryChicken.addIngredient(chicken, 1.5);
        curryChicken.addIngredient(potato, 1.0);
        curryChicken.addIngredient(carrot, 0.5);
        curryChicken.addIngredient(onion, 0.5);
    }

    @Test
    public void canMakeChips() {
        assertTrue(chips.canMake(availableIngredients));
    }

    @Test
    public void cannotMakeFishAndChips() {
        assertFalse(fishAndChips.canMake(availableIngredients));
    }

    @Test
    public void canMakeCurryChicken() {
        assertTrue(curryChicken.canMake(availableIngredients));
    }

}