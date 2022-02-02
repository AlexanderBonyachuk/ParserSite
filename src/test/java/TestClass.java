import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.bonalex.api.Parser.readUrl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @Test
    void enterUrl() {
        // junit test for Scanner
        String input = "https://www.simbirsoft.com/";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("https://www.simbirsoft.com/", readUrl());
    }
}
