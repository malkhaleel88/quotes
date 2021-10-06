/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void appHasAGreeting() {
        try {
            ArrayList<Quotes> quotes = App.readFile();
            assertEquals("Quotes :\n" +
                    "Author : Vasso Charalambous.\n" +
                    "Text :  “The ''wealth'' of a good heard is SO much better than a thousand beautiful faces.�? .", quotes.get(100).toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testJsonReader() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader("../app/src/main/resources/recentquotes.json"));
        assertNotNull(String.valueOf(reader));
    }

    @Test
    public void testAPI() throws IOException {
        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        assertEquals(200, connection.getResponseCode(), String.valueOf(true));
    }

}
