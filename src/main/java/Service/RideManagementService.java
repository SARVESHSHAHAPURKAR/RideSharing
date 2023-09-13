package Service;

import Models.Ride;
import Models.User;
import Models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RideManagementService {

    static int rideNumber=1;

    Map<String, User> cabMappings;

    Map<String, Vehicle> vehicleMappings;

    Map<Integer, Ride> rideMappings;


    List<String> offeredRideVehicles;

    Map<User, List<Integer> > ridesOfferedTaken;

    public RideManagementService(Map<String, User> cabMappings,
     List<String> offeredRideVehicles, Map<String, Vehicle> vehicleMappings,
          Map<Integer, Ride> rideMappings, Map<User, List<Integer> > ridesOfferedTaken) {
        this.cabMappings = cabMappings;
        //this.offeredRides = offeredRides;
        //this.takenRides = takenRides;
        this.offeredRideVehicles = offeredRideVehicles;
        this.vehicleMappings = vehicleMappings;
        this.rideMappings = rideMappings;
        this.ridesOfferedTaken = ridesOfferedTaken;
    }

    public Map<String, User> getCabMappings() {
        return cabMappings;
    }

    public void setCabMappings(Map<String, User> cabMappings) {
        this.cabMappings = cabMappings;
    }

    public List<String> getOfferedRideVehicles() {
        return offeredRideVehicles;
    }

    public void setOfferedRideVehicles(List<String> offeredRideVehicles) {
        this.offeredRideVehicles = offeredRideVehicles;
    }



    public Map<Integer, Ride> getRideMappings() {
        return rideMappings;
    }

    public void setRideMappings(Map<Integer, Ride> rideMappings) {
        this.rideMappings = rideMappings;
    }

    public Map<String, Vehicle> getVehicleMappings() {
        return vehicleMappings;
    }

    public void setVehicleMappings(Map<String, Vehicle> vehicleMappings) {
        this.vehicleMappings = vehicleMappings;
    }

    public void addVehicle(User user, Vehicle vehicle){
        if (cabMappings.containsKey(vehicle.getRegNumber())) {
            System.out.print("The vehicle already exists as a cab");
            return;
        }

        cabMappings.put(vehicle.getRegNumber(), user);
        vehicleMappings.put(vehicle.getRegNumber(), vehicle);

    }

    public void offerRide(User user, String origin, int seats, String vehicleType, String regNum, String destination){

        if(offeredRideVehicles.contains(regNum)){
            System.out.println("Ride already offered for this vehicle");
            return;
        }

        if(!vehicleMappings.containsKey(regNum)){
            System.out.print("Invalid vehicle");
            return;
        }

        Ride ride = new Ride(rideNumber,user,null,origin, destination,vehicleMappings.get(regNum),seats);

        List<Integer> defaultList= new ArrayList<>();
        defaultList.add(0); defaultList.add(0);
        List<Integer> rides = ridesOfferedTaken.getOrDefault(user, defaultList);

        rides.set(0, rides.get(0)+1);


        //offeredRides.add(ride);
        rideMappings.put(rideNumber,ride);

        ridesOfferedTaken.put(user,rides);

        rideNumber++;

        //ide(int, Models.User, Models.User, java.lang.String, java.lang.String, Models.Vehicle, int)' in 'Models.Ride' cannot be applied to '()'

    }

    public void selectRide(User user, String origin, String destination,int seats, String strategy ){

        if(strategy.equalsIgnoreCase("Most Vacant")){

            int maxVacancy=0;
            int rideId= -1;


            for(int id: rideMappings.keySet()){

                Ride ride = rideMappings.get(id);

                if(ride.getOrigin().equalsIgnoreCase(origin) &&
                   ride.getDestination().equalsIgnoreCase(destination) && ride.getSeats()>=seats ){

                    if(ride.getSeats()>maxVacancy){
                        maxVacancy = ride.getSeats();
                        rideId = ride.getId();
                    }
                }
            }

            if(rideId==-1){
                System.out.println("No ride available for "+user.getName()+" from "+origin);
                return;
            }

            System.out.println("Ride alloted "+rideId + " to "+ user.getName());

            List <Integer> defaultList = new ArrayList<>();
            defaultList.add(0); defaultList.add(0);
            List<Integer> rideList = ridesOfferedTaken.getOrDefault(user, defaultList);

            rideList.set(1, rideList.get(1)+1);
            ridesOfferedTaken.put(user, rideList);

            rideMappings.remove(rideId);



        }

        else{

            int maxVacancy=0;
            int rideId= -1;


            for(int id: rideMappings.keySet()){

                Ride ride = rideMappings.get(id);

                if(ride.getOrigin().equalsIgnoreCase(origin) &&
                        ride.getDestination().equalsIgnoreCase(destination) && ride.getSeats()>=seats ){

                    if(ride.getVehicle().getBrand().equalsIgnoreCase(strategy)){
                        //maxVacancy = ride.getSeats();
                        rideId = ride.getId();
                    }
                }
            }

            if(rideId==-1){
                System.out.println("No ride available for "+user.getName()+" from "+origin);
                return;
            }

            System.out.println("Ride alloted "+rideId + " to "+ user.getName());

            List <Integer> defaultList = new ArrayList<>();
            defaultList.add(0); defaultList.add(0);
            List<Integer> rideList = ridesOfferedTaken.getOrDefault(user, defaultList);

            rideList.set(1, rideList.get(1)+1);
            ridesOfferedTaken.put(user, rideList);

            rideMappings.remove(rideId);

        }
    }

    public void printRideStats(){

        for(User user: ridesOfferedTaken.keySet()){

            System.out.println(user.getName() + " Taken : "+ridesOfferedTaken.get(user).get(1)+" Offered : "+ridesOfferedTaken.get(user).get(0));
        }
    }
}
