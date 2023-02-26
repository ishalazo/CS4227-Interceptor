package interceptors;

import java.util.ArrayList;

public class RentalDispatcher {
    private static RentalDispatcher instance;
    private ArrayList<Interceptor> interceptors;

    public RentalDispatcher() {
        interceptors = new ArrayList<Interceptor>();
    }

    public static RentalDispatcher getInstance() {
        if (instance == null)
            instance = new RentalDispatcher();
        return instance;
    }

    public void attach(Interceptor i) {
        interceptors.add(i);
    }

    public void detach(Interceptor i) {
        interceptors.remove(i);
    }

    public void interceptCustomerRental(RentalContext rentalContext) {
        for (Interceptor i : interceptors) {
            RentalDaysInterceptor rdi = (RentalDaysInterceptor) i;
            rdi.interceptCustomerRental(rentalContext);
        }
    }
}
