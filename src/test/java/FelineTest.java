
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @InjectMocks
    Feline feline;

    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        assertEquals(List.of("Мясо"), feline.eatMeat());
    }
    @Test
    public void testGetFoodWhenPredatorShouldReturnMeat() throws Exception {

        List<String> expected = List.of("Мясо");
        List<String> actual = feline.getFood("Хищник");

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFoodWhenNotPredator() {
        Exception exception = assertThrows(Exception.class, () -> {
            feline.getFood("Травоядное");
        });

        String expectedMessage = "Неизвестный вид животного";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}