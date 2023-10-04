import com.example.FelineActions;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    private FelineActions felineActions;

    private final String sex;
    private final boolean expectedMane;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }


    @Test
    public void testLionCreation() throws Exception {
        Lion lion = new Lion(sex, felineActions);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        new Lion("Неправильный пол", felineActions);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineActions.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самка", felineActions);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineActions.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", felineActions);

        List<String> food = lion.getFood();

        assertEquals(3, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }


}
