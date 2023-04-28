package edu.berkeley.letscook;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class DishTest {

    static Map<Ingredient, Quantity> availableIngredients = new HashMap<>();

    // fish and chicken per lb
    // potato, carrot, onion per item (mid-size item / oz)
    // units: cost-USD, calorie-calorie, protein-gram, carbohydrate-gram, fat-gram
    static Ingredient fish = new Ingredient(1, Unit.LB, 8.5, 454, 102, 6, 26);
    static Ingredient potato = new Ingredient(6, Unit.OZ, 0.8, 149, 3.5, 34, 0.2);
    static Ingredient chicken = new Ingredient(1, Unit.LB, 4.5, 1012, 118, 8, 53);
    static Ingredient carrot = new Ingredient(2, Unit.OZ, 0.5, 13, 0.4, 3, 0.1);
    static Ingredient onion = new Ingredient(3, Unit.OZ, 0.5, 44, 1.2, 10, 0.1);
    static Dish chips = new Dish(Method.FRY);
    static Dish fishAndChips = new Dish(Method.FRY);
    static Dish curryChicken = new Dish(Method.STEW);
    static Dish roastChicken = new Dish(Method.ROAST);
    static Dish steamFish = new Dish(Method.STEAM);


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
        curryChicken.addIngredient(carrot, 113.4, Unit.G);
        curryChicken.addIngredient(onion, 42.5, Unit.G);
        roastChicken.addIngredient(chicken, 2, Unit.LB);
        steamFish.addIngredient(fish, 0.5, Unit.KG);
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
    public void caloriesOfFishAndChipsShouldBe875() {
        assertEquals(875, fishAndChips.calories(), 0.01);
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

    // 8th test - fat of a dish, test unit conversion
    @Test
    public void fatOfCurryChickenShouldBe44pt9() {
        assertEquals(44.9, curryChicken.fat(), 0.01);
    }

    // 9th test - add cooking method
    @Test
    public void fatOfRoastChickenShouldBe122() {
        assertEquals(122, roastChicken.fat(), 0.01);
    }

    // 10th test - test methods with 0 ratios
    @Test
    public void caloriesOfSteamFishShouldBe500pt44() {
        assertEquals(500.44, steamFish.calories(), 0.01);
    }

}