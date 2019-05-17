/**
 * Created by Samrat on 10/29/16.
 */
public class Apartment extends Residence {

    private int floorNumber;

    public Apartment(String address, int numBedrooms, int numBathrooms, int squareFootage, double monthlyRent, int floorNumber) {
        super(address, numBedrooms, numBathrooms, squareFootage, monthlyRent);
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return "Address: " + getAddress() + "\n" + "Beds: " + getNumBedrooms() + "\n" + "Baths: " +
                getNumBathrooms() + "\n" + "Sqft: " + getSquareFootage() + "\n" + "Rent: " +
                String.format("%.2f" ,getMonthlyRent()) +
                "\n" + "Floor: " + getFloorNumber();
    }
}
