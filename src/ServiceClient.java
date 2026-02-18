import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ServiceClient {

    public static void main(String[] args) throws Exception {

        System.out.println("Weather Service Response:");
        callService("http://localhost:8081/weather");

        System.out.println("\nAlert Service Response:");
        callService("http://localhost:8082/alerts");

        System.out.println("\nLocation Service Response:");
        callService("http://localhost:8083/locations");
    }

    private static void callService(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
