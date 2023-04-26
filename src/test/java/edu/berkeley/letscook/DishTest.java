package edu.berkeley.letscook;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class DishTest {

    static Map<Ingredient, Double> availableIngredients = new HashMap<>();

    // fish and chicken per pound
    // potato, carrot, onion per item
    // units: cost-USD, calorie-calorie, protein-gram, carbohydrate-gram, fat-gram
    static Ingredient fish = new Ingredient(8.5, 230, 28);
    static Ingredient potato = new Ingredient(0.8, 161, 3.5);
    static Ingredient chicken = new Ingredient(4.5, 600, 80);
    static Ingredient carrot = new Ingredient(0.5, 25, 0.8);
    static Ingredient onion = new Ingredient(0.5, 44, 1.2);
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
        fishAndChips.addIngredient(fish, 1.5);
        fishAndChips.addIngredient(potato, 1.0);
        curryChicken.addIngredient(chicken, 1.2);
        curryChicken.addIngredient(potato, 1.0);
        curryChicken.addIngredient(carrot, 0.5);
        curryChicken.addIngredient(onion, 0.5);
    }

    // 1st test - canMake dishes with one ingredient
    @Test
    public void canMakeChips() {
        assertTrue(chips.canMake(availableIngredients));
    }

    // 2nd test - canMake false with unavailable ingredients
    @Test
    public void cannotMakeFishAndChips() {
        assertFalse(fishAndChips.canMake(availableIngredients));
    }

    // 3rd test - add quantity into ingredients hashmap
    @Test
    public void canMakeCurryChicken() {
        assertTrue(curryChicken.canMake(availableIngredients));
    }

    // 4th test - cost of a dish
    @Test
    public void costOfFishAndChipsShouldBe13pt55() {
        assertEquals(13.55, fishAndChips.cost(), 0.01);
    }

    // 5th test - calories of a dish
    @Test
    public void caloriesOfFishAndChipsShouldBe506() {
        assertEquals(506, fishAndChips.calories(), 0.01);
    }

    // 6th test - protein of a dish, implement strategy pattern
    @Test
    public void proteinOfCurryChickenShouldBe100pt5() {
        assertEquals(100.5, curryChicken.protein(), 0.01);
    }

}