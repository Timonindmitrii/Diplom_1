import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class TestUnitBurgerClass {

    Burger burger;


    @Before
    public void setUp() {
        burger = new Burger();

    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient anotherIngredient;


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);

    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int expected = 1;

        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        int expected = 0;

        assertEquals(expected, burger.ingredients.size());

    }


    @Test
    public void moveIngredientTest() {
        burger.ingredients.addAll(Arrays.asList(ingredient, anotherIngredient));
        List<Ingredient> actual = new ArrayList<>(Arrays.asList(anotherIngredient, ingredient));

        burger.moveIngredient(0, 1);

        assertEquals(actual, burger.ingredients);
    }


    @Test
    public void getPriceBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getPrice()).thenReturn(200F);
        when(ingredient.getPrice()).thenReturn(100F);

        assertEquals(500, burger.getPrice(), 0);

    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("Сладкая булочка");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient.getPrice()).thenReturn(500F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                        ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expected, burger.getReceipt());
    }



}
