package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import app.Movie;
import app.RegularPrice;
import app.Rental;

public class RentalDaysInterceptorTest {
    @Test
    public void testInterceptCustomerRental() {
        Movie movie = new Movie("Test Movie", new RegularPrice());
        int daysRented = 50;
        Rental rental = new Rental(movie, daysRented);

        // Assert that the interceptor has limited the rental days to 30 days
        assertEquals(30, rental.getDaysRented());
    }
}
