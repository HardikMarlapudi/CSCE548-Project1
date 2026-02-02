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

            switch (choice) {

                case 1:
                    weatherDAO.getAllRecords().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Location ID: ");
                    int loc = scanner.nextInt();

                    System.out.print("Condition ID: ");
                    int cond = scanner.nextInt();

                    System.out.print("Temperature: ");
                    double temp = scanner.nextDouble();

                    System.out.print("Humidity: ");
                    int hum = scanner.nextInt();

                    weatherDAO.addRecord(new WeatherRecord(
                            0,
                            loc,
                            cond,
                            temp,
                            hum,
                            new Date(System.currentTimeMillis())
                    ));

                    System.out.println("Weather record added.");
                    break;

                case 3:
                    System.out.print("Record ID to delete: ");
                    int recordId = scanner.nextInt();
                    weatherDAO.deleteRecord(recordId);
                    System.out.println("Weather record deleted.");
                    break;

                case 4:
                    alertDAO.getAllAlerts().forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("User ID: ");
                    int userId = scanner.nextInt();

                    System.out.print("Location ID: ");
                    int locationId = scanner.nextInt();

                    scanner.nextLine(); // clear newline
                    System.out.print("Alert message: ");
                    String message = scanner.nextLine();

                    alertDAO.addAlert(new Alert(0, userId, locationId, message));
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
