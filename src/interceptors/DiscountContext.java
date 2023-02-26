package interceptors;

import app.Customer;

public class DiscountContext {
    private Customer customer;

    public DiscountContext(Customer customer) {
        this.customer = customer;
    }



    public String getFirstTitleString(){
        return customer.getRentals().get(0).getMovie().getTitle();
    }


    public double getTotalCharge() {
        return customer.getTotalCharge();
    }

}
