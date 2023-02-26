package interceptors;

import app.Rental;

public class RentalContext {
    private Rental rental;

    public RentalContext(Rental rental) {
        this.rental = rental;
    }

    public Rental getRental() {
        return rental;
    }

}
