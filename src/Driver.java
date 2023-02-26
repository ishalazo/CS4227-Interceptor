import app.*;
import interceptors.*;


public class Driver {
    public static void main(String[] args) {
        // Warning Interception
        RentalWarningInterceptor rentalInterceptor = new RentalWarningInterceptor();
        RentalWarningDispatcher.getInstance().attach(rentalInterceptor);

        // Initialise
        Customer customer1 = new Customer("Blake Rosenberg");
        Movie movie = new Movie("Inception", new RegularPrice());
        Rental rental = new Rental(movie, 20);

        // Call point of interception 1
        customer1.addRental(rental);

        System.out.println();
        
        // Discount Interception
        DiscountInterceptor discountInterceptor = new DiscountInterceptor();
        DiscountDispatcher.getInstance().attach(discountInterceptor);

        // Initialise
        Customer customer2 = new Customer("Terry Sato");
        Movie inception = new Movie("Avatar", new NewReleasePrice());
        Rental inceptionRental = new Rental(inception, 10);
        customer2.addRental(inceptionRental);
        Movie toyStory = new Movie("Toy Story", new ChildrensPrice());
        Rental toyStoryRental = new Rental(toyStory, 10);
        customer2.addRental(toyStoryRental);

        // Call point of interception 2
        customer2.statement();
    }
}
