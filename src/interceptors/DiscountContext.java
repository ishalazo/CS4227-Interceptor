package interceptors;

import app.Customer;

public class DiscountContext {
    private Customer customer;

    public DiscountContext(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getFirstTitleString(){
        return customer.getRentals().get(0).getMovie().getTitle();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
