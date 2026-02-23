import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class WeatherService {

    public static void startService() throws Exception {

        WeatherBusiness business = new WeatherBusiness();

        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);

        server.createContext("/weather", exchange -> {
            String response = business.getAllWeatherRecords().toString();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Weather Service running at http://localhost:8081/weather");
    }
}
