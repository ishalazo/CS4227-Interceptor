package app;

import java.util.ArrayList;
import java.util.List;

import interceptors.DiscountContext;
import interceptors.DiscountDispatcher;
import interceptors.RentalContext;
import interceptors.RentalWarningDispatcher;

public class Customer {
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        // Point of interception: Warn when rentalDays is more than 14 days.
        RentalContext rentalContext = new RentalContext(rental);
        RentalWarningDispatcher.getInstance().interceptCustomerRental(rentalContext);

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
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + frequentRenterPoints() + " frequent renter points";

        // Point of Interception: Give a 10% discount when Customer spends more than 25 on rentals
        DiscountContext discountContext = new DiscountContext(this);
        DiscountDispatcher.getInstance().interceptDiscount(discountContext);

        return result;

    }

    public double getTotalCharge() {
        double result = 0;
        for (Rental each : rentals) {
            result += each.getCharge();
        }
        return result;
    }

    public int frequentRenterPoints() {
        int totalRenterPoints = 0;
        for (Rental each : rentals) {
            totalRenterPoints += each.getFrequentRenterPoints();
        }
        return totalRenterPoints;
    }

}
