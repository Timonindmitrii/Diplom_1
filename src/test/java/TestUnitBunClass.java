import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestUnitBunClass {
    private Bun bun;
    private final String nameExpected;
    private final float priceExpected;

    public TestUnitBunClass(String nameExpected, float priceExpected) {
        this.nameExpected = nameExpected;
        this.priceExpected = priceExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCountData() {
        return new Object[][]{
                {"", Float.MAX_VALUE},
                {"!@#!$%^&*()_~", 0f},
                {"null", -99999f},
                {"234234234", 345323.533f},
                {"ОЧЕНЬ ДЛИННОЕ НАЗВАНИЕ КОТОРОЕ Я НЕ СМОГ ПРИДУМАТЬ НО ОЧЕНЬ СТАРАЛСЯ", 1f},
                {"0", Float.MIN_VALUE},
        };
    }

    @Test
    public void createBunGetNameTest() {
        bun = new Bun(nameExpected, priceExpected);

        Assert.assertEquals(nameExpected, bun.getName());

    }

    @Test
    public void createBunGetPriceTest() {
        bun = new Bun(nameExpected, priceExpected);

        assertEquals(priceExpected, bun.getPrice(), 0);
    }


}