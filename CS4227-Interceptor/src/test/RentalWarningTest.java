package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
 
import org.junit.Before;
import org.junit.Test;

import app.Customer;
import app.Movie;
import app.RegularPrice;
import app.Rental;
import interceptors.RentalWarningDispatcher;
import interceptors.RentalWarningInterceptor;

public class RentalWarningTest { 
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testWarning() {
        RentalWarningInterceptor rentalInterceptor = new RentalWarningInterceptor();
        RentalWarningDispatcher.getInstance().attach(rentalInterceptor);

        // Initialise
        Customer customer = new Customer("Blake Rosenberg");
        Movie movie = new Movie("Inception", new RegularPrice());
        Rental rental = new Rental(movie, 20);

        // Call point of interception
        customer.addRental(rental);

        // Expected output
        String expected = "WARNING: Movies can only be rented for 14 days. The movie, 'INCEPTION', has been rented for 20 days.";

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}
