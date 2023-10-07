import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;


public class TestFeline {

    Feline feline = new Feline();

    @Test
    public void testGetKittens() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }
    @Test
    public void testGetFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }
    @Test
    public void testEatMeat() throws Exception {
        List<String> list = feline.eatMeat();
        int expected = 3;
        int actual = list.size();
        assertEquals(expected, actual);
    }
    @Test
    public void testUnknownAnimalKindException() {
        assertThrows(Exception.class, () -> feline.getFood("Бобёр"));
    }
}