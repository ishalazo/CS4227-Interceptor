package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import app.ChildrensPrice;
import app.Customer;
import app.Movie;
import app.NewReleasePrice;
import app.Rental;
import interceptors.DiscountDispatcher;
import interceptors.DiscountInterceptor;

public class DiscountTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testWarning() {
        DiscountInterceptor discountInterceptor = new DiscountInterceptor();
        DiscountDispatcher.getInstance().attach(discountInterceptor);

        // Initialise
        Customer customer = new Customer("Terry Sato");
        Movie inception = new Movie("Avatar", new NewReleasePrice());
        Rental inceptionRental = new Rental(inception, 10);
        customer.addRental(inceptionRental);
        Movie toyStory = new Movie("Toy Story", new ChildrensPrice());
        Rental toyStoryRental = new Rental(toyStory, 10);
        customer.addRental(toyStoryRental);

        // Call point of interception
        customer.statement();

        // Expected output
        String expected = "Thank you for your patronage! Next time you order online, please use discount code AVA10 to have 10% off your next purchase.";

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}
