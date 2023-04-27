package edu.berkeley.letscook;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class DishTest {

    static Map<Ingredient, Quantity> availableIngredients = new HashMap<>();

    // fish and chicken per pound
    // potato, carrot, onion per oz
    // units: cost-USD, calorie-calorie, protein-gram, carbohydrate-gram, fat-gram
    static Ingredient fish = new Ingredient(1, Unit.LB, 8.5, 454, 102, 6, 26);
    static Ingredient potato = new Ingredient(6, Unit.OZ, 0.8, 149, 3.5, 34, 0.2);
    static Ingredient chicken = new Ingredient(1, Unit.LB, 4.5, 1012, 118, 8, 53);
    static Ingredient carrot = new Ingredient(2, Unit.OZ, 0.5, 13, 0.4, 3, 0.1);
    static Ingredient onion = new Ingredient(3, Unit.OZ, 0.5, 44, 1.2, 10, 0.1);
    static Dish chips = new Dish();
    static Dish fishAndChips = new Dish();
    static Dish curryChicken = new Dish();


    static {
        availableIngredients.put(potato, new Quantity(30, Unit.OZ));
        availableIngredients.put(fish, new Quantity(1, Unit.LB));
        availableIngredients.put(chicken, new Quantity(2.5, Unit.LB));
        availableIngredients.put(carrot, new Quantity(10, Unit.OZ));
        availableIngredients.put(onion, new Quantity(6, Unit.OZ));

        chips.addIngredient(potato, 0.5, Unit.LB);
        fishAndChips.addIngredient(fish, 1.5, Unit.LB);
        fishAndChips.addIngredient(potato, 6, Unit.OZ);
        curryChicken.addIngredient(chicken, 12, Unit.OZ);
        curryChicken.addIngredient(potato, 6, Unit.OZ);
        curryChicken.addIngredient(carrot, 4, Unit.OZ);
        curryChicken.addIngredient(onion, 1.5, Unit.OZ);
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
    public void caloriesOfFishAndChipsShouldBe830() {
        assertEquals(830, fishAndChips.calories(), 0.01);
    }

    // 6th test - protein of a dish, implement strategy pattern
    @Test
    public void proteinOfCurryChickenShouldBe93pt4() {
        assertEquals(93.4, curryChicken.protein(), 0.01);
    }

    // 7th test - carbohydrate of a dish, add units to Quantity
    @Test
    public void carbohydrateOfCurryChickenShouldBe51() {
        assertEquals(51, curryChicken.carbohydrate(), 0.01);
    }

}