import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestUnitBunClass {

    @Test
    public void getNameBunTest(){
    Bun bun = new Bun("Булочка",  44);

    String expected = "Булочка";
    String actual = bun.getName();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getPriceBunTest(){
        Bun bun = new Bun("Булочка",  44f);
        float expected = 44f;
        float actual = bun.getPrice();

        Assert.assertEquals(expected,actual,0);
    }
}
