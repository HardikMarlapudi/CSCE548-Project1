public class ServiceLauncher {

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            try {
                WeatherService.startService();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                AlertService.startService();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                LocationService.startService();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
