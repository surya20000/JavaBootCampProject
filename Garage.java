//* This is going to be a small garage interface where the user have the ability to add new vehicles in his garage and can keep a track over his vehcile for their service dates */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class Vehicle {
    private String vehicleName;
    private String dateAtWhichVehicleWasBrought;
    protected LocalDate expiredDate;
    final static String pattern = "dd-MM-yyyy";

    protected Vehicle(String vehicleName, String dateAtWhichVehicleWasBrought) {
        this.vehicleName = vehicleName;
        this.dateAtWhichVehicleWasBrought = dateAtWhichVehicleWasBrought;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate boughtDate = LocalDate.parse(dateAtWhichVehicleWasBrought, formatter);
        this.expiredDate = boughtDate.plusMonths(3);
    }

    abstract void checkServiceTime(String currentDate);

    protected String getVehicleName() {
        return vehicleName;
    }

    protected String getDateAtWhichVehicleWasBrought() {
        return dateAtWhichVehicleWasBrought;
    }
}

class TwoWheeler extends Vehicle {

    public TwoWheeler(String vehicleName, String dateAtWhichVehicleWasBrought) {
        super(vehicleName, dateAtWhichVehicleWasBrought);
    }

    void checkServiceTime(String currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate current = LocalDate.parse(currentDate, formatter);

        if (current.isAfter(expiredDate)) {
            System.out.println(getVehicleName() + ":- " + "Needs to get the service done.");
            System.out.println("It's time for you to contact your nearest service station!!!");
        } else {
            System.out.println(getVehicleName() + ":- " + "Is Up to date.");
            System.out.println("No need for you to service your vehicle!!");
        }
    }
}

class FourWheeler extends Vehicle {

    public FourWheeler(String vehicleName, String dateAtWhichVehicleWasBrought) {
        super(vehicleName, dateAtWhichVehicleWasBrought);
    }

    void checkServiceTime(String currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate current = LocalDate.parse(currentDate, formatter);

        if (current.isAfter(expiredDate)) {
            System.out.println(getVehicleName() + ":- " + "Needs to get the service done.");
            System.out.println("It's time for you to contact your nearest service station!!!");
        } else {
            System.out.println(getVehicleName() + ":- " + "Is Up to date.");
            System.out.println("No need for you to service your vehicle!!");
        }
    }
}

public class Garage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to your Garage!!");
        System.out.println("Your Garage is empty as of Now let's add a vehicle first");
        System.out.println("Type 1 for adding a two wheeler vehicle and 2 for adding a four wheeler vehicle");
        String userEnteredCategory = sc.nextLine();
        switch (userEnteredCategory) {
            case "1":
                System.out.println("Enter the Model name of your Vehicle");
                String mName = sc.nextLine();
                System.out.println("Enter the date at which the Vehicle was bought (dd-MM-yyyy)");
                String vehicleBoughtDate = sc.nextLine();
                System.out.println("Enter today's date (dd-MM-yyyy)");
                String currDate = sc.nextLine();
                TwoWheeler newTwoWheeler = new TwoWheeler(mName, vehicleBoughtDate);
                newTwoWheeler.checkServiceTime(currDate);
                break;
            case "2":
                System.out.println("Enter the Model name of your Vehicle");
                String ModelName = sc.nextLine();
                System.out.println("Enter the date at which the Vehicle was bought (dd-MM-yyyy)");
                String vehicleBroughtDate = sc.nextLine();
                System.out.println("Enter today's date (dd-MM-yyyy)");
                String currentDate = sc.nextLine();
                FourWheeler newFourWheeler = new FourWheeler(ModelName, vehicleBroughtDate);
                newFourWheeler.checkServiceTime(currentDate);
                break;
            default:
                System.out.println("Invalid Category Entered!!");
        }
        sc.close();
    }
}