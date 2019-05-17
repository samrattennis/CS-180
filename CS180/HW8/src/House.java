/**
 * Created by Samrat on 10/29/16.
 */
public class House extends Residence {
    private int numFloors;
    private boolean hasGarage;


    public House(String address, int numBedrooms, int numBathrooms, int squareFootage, double monthlyRent,
                 int numFloors, boolean hasGarage) {
        super(address, numBedrooms, numBathrooms, squareFootage, monthlyRent);
        this.numFloors = numFloors;
        this.hasGarage = hasGarage;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    @Override
    public String toString() {
        return "Address: " + getAddress() + "\n" + "Beds: " + getNumBedrooms() + "\n" + "Baths: " +
                getNumBathrooms() + "\n" + "Sqft: " + getSquareFootage() + "\n" + "Rent: " +
                String.format("%.2f" , getMonthlyRent()) + "\n" + "Floor: " + getNumFloors() + "\n" + "Has Garage: " + hasGarage();
    }
}
