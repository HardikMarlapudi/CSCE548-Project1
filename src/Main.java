import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WeatherRecordDAO weatherDAO = new WeatherRecordDAO();
        AlertDAO alertDAO = new AlertDAO();

        while (true) {
            System.out.println("\nWeather Management System");
            System.out.println("1. View Weather Records");
            System.out.println("2. Add Weather Record");
            System.out.println("3. Delete Weather Record");
            System.out.println("4. View Alerts");
            System.out.println("5. Add Alert");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    weatherDAO.getAllRecords().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("City name: ");
                    String city = scanner.nextLine();

                    System.out.print("Station name: ");
                    String station = scanner.nextLine();

                    System.out.print("Condition (Sunny/Rainy/Cloudy): ");
                    String condition = scanner.nextLine();

                    System.out.print("Temperature: ");
                    double temp = scanner.nextDouble();

                    System.out.print("Humidity: ");
                    int humidity = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    weatherDAO.addRecord(
                        new WeatherRecord(
                            city,
                            station,
                            condition,
                            temp,
                            humidity,
                            new Date(System.currentTimeMillis())
                        )
                    );

                    System.out.println("Weather record added.");
                    break;

                case 3:
                    System.out.print("Record ID to delete: ");
                    int recordId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    weatherDAO.deleteRecord(recordId);
                    System.out.println("Weather record deleted.");
                    break;

                case 4:
                    alertDAO.getAllAlerts().forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Location name: ");
                    String location = scanner.nextLine();

                    System.out.print("Alert message: ");
                    String message = scanner.nextLine();

                    alertDAO.addAlert(new Alert(location, message));
                    System.out.println("Alert added.");
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
