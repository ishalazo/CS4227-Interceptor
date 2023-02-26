package app;

import java.util.ArrayList;
import java.util.List;

import interceptors.RentalContext;

public class Customer {
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        // RentalContext co = new RentalContext(rental);

        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String statement() {
        String result = "Rental Record for " + name + "\n";
        for (Rental each : rentals) {
            // values for rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        // footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + frequentRenterPoints() + " frequent renter points";
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
