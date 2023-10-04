import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


public class CatTests {

    private Cat cat;

    @Before
    public void setUp() {
        Feline feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        String actual = cat.getSound();
        String expected = "Мяу";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Мясо");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorSetsPredator() {
        Predator predator = cat.predator;

        Assert.assertTrue(predator instanceof Feline);
    }

}
