package interceptors;

import app.Rental;

public class RentalContext {
    private Rental rental;

    public RentalContext(Rental rental) {
        this.rental = rental;
    }

    public int getDaysRented() {
        return rental.getDaysRented();
    }

    public String getTitle(){
        return rental.getMovie().getTitle();
    }

}
