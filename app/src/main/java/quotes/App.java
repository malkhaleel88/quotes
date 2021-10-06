/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) throws IOException {

//        int value =new Random().nextInt(readFile().size()-1);
//        System.out.println("The Index Of Quote : " + value);
//        System.out.println(readFile().get(value).toString());
//    }
//    public static ArrayList<Quotes> readFile() throws IOException {
//        BufferedReader reader =new BufferedReader(new FileReader("./app/src/main/resources/recentquotes.json"));
//        Type quotesArrayList = new TypeToken<ArrayList<Quotes>>() {}.getType();
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        ArrayList<Quotes> converter = gson.fromJson(reader, quotesArrayList);
//        return converter;
//    }

        Gson gson = new Gson();

        BufferedReader reader = new BufferedReader(new FileReader("./app/src/main/resources/recentquotes.json"));
        List<Quotes> quote = gson.fromJson(reader, new TypeToken<List<Quotes>>() {
        }.getType());
        reader.close();

        int min = 0;
        int max = quote.size() - 1;

        try {
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            BufferedWriter add = new BufferedWriter(new FileWriter("./app/src/main/resources/recentquotes.json", false));
            QuotesAPI qutApi = gson.fromJson(bufferedReader, QuotesAPI.class);
            Quotes quotLocal = new Quotes(null, qutApi.getQuoteAuthor(), null, qutApi.getQuoteText());
            quote.add(quotLocal);
            gson = gson.newBuilder().setPrettyPrinting().create();


            System.out.println("Quote from API: " + quotLocal);
            add.write(gson.toJson(quote));
            add.close();

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("This Data From Local");
            System.out.println(quote.get((int) (Math.random() * (max - min + 1) + min)).toString());
        }

    }
}