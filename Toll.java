import java.util.*;

// Define TollPass class to store pass details
class TollPass {
    private String passType;
    private double twoWheelerPrice;
    private double fourWheelerPrice;

    public TollPass(String passType, double twoWheelerPrice, double fourWheelerPrice) {
        this.passType = passType;
        this.twoWheelerPrice = twoWheelerPrice;
        this.fourWheelerPrice = fourWheelerPrice;
    }

    public String getPassType() {
        return passType;
    }

    public double getTwoWheelerPrice() {
        return twoWheelerPrice;
    }

    public double getFourWheelerPrice() {
        return fourWheelerPrice;
    }
}

// Define TollBooth class to store booth details
class TollBooth {
    private String boothName;
    private String tollName;

    public TollBooth(String boothName, String tollName) {
        this.boothName = boothName;
        this.tollName = tollName;
    }

    public String getBoothName() {
        return boothName;
    }

    public String getTollName() {
        return tollName;
    }
}

// Define Vehicle class to store vehicle details
class Vehicle {
    private String registrationNumber;
    private String vehicleType;

    public Vehicle(String registrationNumber, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}

// Define SaleRecord class to store sales details
class SaleRecord {
    private String tollBooth;
    private String vehicleType;
    private String passType;
    private String vehicleRegistration;
    private double price;

    public SaleRecord(String tollBooth, String vehicleType, String passType, String vehicleRegistration, double price) {
        this.tollBooth = tollBooth;
        this.vehicleType = vehicleType;
        this.passType = passType;
        this.vehicleRegistration = vehicleRegistration;
        this.price = price;
    }

    public String getTollBooth() {
        return tollBooth;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getPassType() {
        return passType;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public double getPrice() {
        return price;
    }
}

public class TollManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create collections to store data
        Map<String, TollBooth> tollBooths = new HashMap<>();
        Map<String, TollPass> tollPasses = new HashMap<>();
        Map<String, Vehicle> vehicles = new HashMap<>();
        List<SaleRecord> salesRecords = new ArrayList<>();

        // Initialize sample data
        TollPass singlePass = new TollPass("Single Pass", 50.0, 100.0);
        TollPass returnPass = new TollPass("Return Pass", 80.0, 160.0);
        TollPass sevenDayPass = new TollPass("Seven-Day Pass", 300.0, 600.0);

        tollPasses.put("Single Pass", singlePass);
        tollPasses.put("Return Pass", returnPass);
        tollPasses.put("Seven-Day Pass", sevenDayPass);

        TollBooth tollBooth1 = new TollBooth("Toll1_Booth1", "Toll1");
        TollBooth tollBooth2 = new TollBooth("Toll1_Booth2", "Toll1");

        tollBooths.put("Toll1_Booth1", tollBooth1);
        tollBooths.put("Toll1_Booth2", tollBooth2);

        // Example usage
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Record Sale");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                scanner.nextLine();  // Consume the newline character

                System.out.print("Enter toll booth name: ");
                String tollBoothName = scanner.nextLine();

                System.out.print("Enter vehicle registration number: ");
                String vehicleRegistration = scanner.nextLine();

                System.out.print("Enter pass type (Single Pass/Return Pass/Seven-Day Pass): ");
                String passType = scanner.nextLine();

                if (!vehicles.containsKey(vehicleRegistration)) {
                    System.out.print("Enter vehicle type (Two Wheeler/Four Wheeler): ");
                    String vehicleType = scanner.nextLine();

                    Vehicle newVehicle = new Vehicle(vehicleRegistration, vehicleType);
                    vehicles.put(vehicleRegistration, newVehicle);
                }

                if (tollBooths.containsKey(tollBoothName) && tollPasses.containsKey(passType)) {
                    String vehicleType = vehicles.get(vehicleRegistration).getVehicleType();
                    double price = 0.0;

                    if ("Two Wheeler".equalsIgnoreCase(vehicleType)) {
                        price = tollPasses.get(passType).getTwoWheelerPrice();
                    } else if ("Four Wheeler".equalsIgnoreCase(vehicleType)) {
                        price = tollPasses.get(passType).getFourWheelerPrice();
                    }

                    SaleRecord saleRecord = new SaleRecord(tollBoothName, vehicleType, passType, vehicleRegistration, price);
                    salesRecords.add(saleRecord);

                    System.out.println("Sale recorded successfully. Price: " + price + " INR");
                } else {
                    System.out.println("Invalid toll booth or pass type.");
                }
            } else if (choice == 2) {
                break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
