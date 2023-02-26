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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
