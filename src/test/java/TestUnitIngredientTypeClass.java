import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestUnitIngredientTypeClass {

    @Test
    public void valueOfIngredientTypeTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
