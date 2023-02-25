package interceptors;

import app.Customer;

public class ContextObject {
    private Customer customer;

    public ContextObject(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
