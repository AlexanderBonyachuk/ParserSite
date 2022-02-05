import com.bonalex.api.Processing;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.bonalex.api.Processing.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    void checkSingleton() {
        Processing p1 = getModel();
        Processing p2 = getModel();
        assertEquals(p1, p2);
    }

    @Test
    void enterUrl() {
        // junit test for Scanner
        String input = "https://www.simbirsoft.com/";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("https://www.simbirsoft.com/", getModel().readUrl());
    }

    @Test
    void returnMapWithText() {
        Map<String, Integer> map = new HashMap<>();
        map.put("WORD", 3);
        String testString =
                "!«word/», -045.'word%':!!! .[?]].. ! \"85!\" ,,(4); ; ,.\n" +
                        "?.,,\n" +
                        " \t ?? . word!";
        assertEquals(map,getModel().tableWithText(testString));
    }

}
