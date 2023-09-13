package Main;

import Models.Ride;
import Models.User;
import Models.Vehicle;
import Service.RideManagementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, User> cabMappings = new HashMap<>();
        List<String> offeredRideVehicles = new ArrayList<>();
        Map<String, Vehicle> vehicleMappings = new HashMap<>();

        Map<Integer, Ride> rideMappings = new HashMap<>();
        Map<User, List<Integer> > ridesOfferedTaken = new HashMap<>();

        RideManagementService service = new RideManagementService(cabMappings, offeredRideVehicles,
                vehicleMappings,rideMappings, ridesOfferedTaken);

        User user1  = new User("Rohan","M", 36);
        service.addVehicle(user1, new Vehicle("Swift", "KA-01-12345", "Rohan"));

        User user2 = new User("Shashank", "M", 29);
        service.addVehicle(user2, new Vehicle("Baleno", "TS-05-62395","Shashank"));

        User user3 = new User("Nandini", "F", 29);
        User user4 = new User ("Shipra", "F", 27);

        service.addVehicle(user4, new Vehicle( "Polo", "KA-05-41491", "Shipra"));
        service.addVehicle(user4, new Vehicle("Activa", "KA-12-12332","Shipra"));

        User user5 = new User("Gaurav", "M", 29);

        User user6 = new User("Rahul", "M", 35);
        service.addVehicle(user6, new Vehicle("XUV", "KA-05-1234","Rahul"));


        service.offerRide(user1,"Hyderabad",1,"Swift","KA-01-12345","Bangalore");
        service.offerRide(user4, "Bangalore", 1, "Activa" ,"KA-12-12332","Mysore");
        service.offerRide(user4, "Bangalore", 2, "Polo", "KA-05-41491", "Mysore");
        service.offerRide(user2, "Hyderabad", 2, "Baleno", "TS-05-62395", "Bangalore");
        service.offerRide(user6, "Hyderabad", 5, "XUV",  "KA-05-1234", "Bangalore");
        service.offerRide(user1, "Bangalore", 1, "Swift", "KA-01-12345", "Pune");

        service.selectRide(user3, "Bangalore", "Mysore", 1, "Most Vacant");
        service.selectRide(user5, "Bangalore", "Mysore", 1, "Activa");
        service.selectRide(user2, "Mumbai", "Bangalore", 1, "Most Vacant");
        service.selectRide(user1, "Hyderabad", "Bangalore", 1, "Baleno");
        service.selectRide(user2, "Hyderabad","Bangalore", 1,"Polo");

        System.out.println("*****************");

        service.printRideStats();



    }
}