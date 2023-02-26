package interceptors;

public class RentalWarningInterceptor implements Interceptor {

    public void interceptCustomerRental(RentalContext co) {
        if(co.getRental().getDaysRented() > 14)
            System.out.printf("WARNING: Movies can only be rented for 14 days. The movie, '%s', has been rented for %d days.", co.getRental().getMovie().getTitle().toUpperCase(), co.getRental().getDaysRented());
    }
}
