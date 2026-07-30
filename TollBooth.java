import java.util.Scanner;

// Record definition
record Vehicle(String number, String type) {}

public class TollBooth {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {
            System.out.print("Enter vehicle number (type DONE to stop): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("DONE")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            // Switch expression
            int toll = switch (v.type()) {
                case "bike" -> {
                    bike++;
                    yield 20;
                }
                case "car" -> {
                    car++;
                    yield 50;
                }
                case "truck" -> {
                    truck++;
                    yield 150;
                }
                default -> {
                    System.out.println("Invalid vehicle type! Toll = 0");
                    yield 0;
                }
            };

            total += toll;
        }

        // Find most frequent vehicle type
        String mostFrequent;

        if (bike >= car && bike >= truck) {
            mostFrequent = "bike";
        } else if (car >= bike && car >= truck) {
            mostFrequent = "car";
        } else {
            mostFrequent = "truck";
        }

        // Output
        System.out.println("\nTotal toll: " + total);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}