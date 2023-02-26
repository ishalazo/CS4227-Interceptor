package interceptors;

import app.Customer;

public class DiscountContext {
    private Customer customer;
    private String statement;

    public DiscountContext(Customer customer, String statement) {
        this.customer = customer;
        this.statement = statement;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

}
