import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() { 
        String result = "Rental Record for " + name + "\n";
        for (Rental each : rentals) { 
            // values for rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        // footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints()) + " frequent renter points";
        return result;

    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental each : rentals) {
            result += each.getCharge();
        }
        return result;
    } 

    private int frequentRenterPoints() {
        int totalRenterPoints = 0;
        for (Rental each : rentals) {
            totalRenterPoints += each.getFrequentRenterPoints();
        }
        return totalRenterPoints;
    }

}
