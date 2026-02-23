import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class LocationService {

    public static void startService() throws Exception {

        LocationBusiness business = new LocationBusiness();

        HttpServer server = HttpServer.create(new InetSocketAddress(8083), 0);

        server.createContext("/locations", exchange -> {
            String response = business.getAllLocations().toString();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Location Service running at http://localhost:8083/locations");
    }
}
