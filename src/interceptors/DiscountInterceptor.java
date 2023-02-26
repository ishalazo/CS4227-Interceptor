package interceptors;

public class DiscountInterceptor implements Interceptor {

    public void interceptDiscount(DiscountContext discountContext) {
        if(discountContext.getCustomer().getTotalCharge() > 25) {
            // Discount code is the first 3 letters of the first movie that in Customer's rentals list
            String discountCode = discountContext.getCustomer().getRentals().get(0).getMovie().getTitle().substring(0,3).toUpperCase();
            System.out.printf("Thank you for your patronage! Next time you order online, please use discount code %s10 to have 10%% off your next purchase.", discountCode);
        }
    }

}
