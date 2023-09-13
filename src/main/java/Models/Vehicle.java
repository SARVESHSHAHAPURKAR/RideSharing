package Models;

public class Vehicle {

    String brand;

    String regNumber;

    String owner;

    public Vehicle(String brand, String regNumber, String owner) {
        this.brand = brand;
        this.regNumber = regNumber;
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
