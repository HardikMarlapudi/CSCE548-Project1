import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class AlertService {

    public static void startService() throws Exception {

        AlertBusiness business = new AlertBusiness();

        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);

        server.createContext("/alerts", exchange -> {
            String response = business.getAllAlerts().toString();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Alert Service running on port 8082");
    }
}
