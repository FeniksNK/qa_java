import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> expectedFood;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    public AnimalTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood(animalKind);
        assertEquals(expectedFood, food);
    }

    @Test(expected = Exception.class)
    public void testGetFoodInvalid() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неправильное значение");
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertNotNull(family);
        assertTrue(family.contains("заячьи"));
        assertTrue(family.contains("беличьи"));
        assertTrue(family.contains("мышиные"));
        assertTrue(family.contains("кошачьи"));
        assertTrue(family.contains("псовые"));
        assertTrue(family.contains("медвежьи"));
        assertTrue(family.contains("куньи"));
    }

}
