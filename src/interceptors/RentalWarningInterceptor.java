package interceptors;

public class RentalWarningInterceptor implements Interceptor {

    public void interceptCustomerRental(RentalContext rentalContext) {
        if(rentalContext.getDaysRented() > 14)
            System.out.printf("WARNING: Movies can only be rented for 14 days. The movie, '%s', has been rented for %d days.", rentalContext.getTitle().toUpperCase(), rentalContext.getDaysRented());
    }
}
