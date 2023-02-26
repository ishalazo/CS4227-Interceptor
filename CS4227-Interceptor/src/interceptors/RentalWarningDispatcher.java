package interceptors;

import java.util.ArrayList;

public class RentalWarningDispatcher {
    private static RentalWarningDispatcher instance;
    private ArrayList<Interceptor> interceptors;

    public RentalWarningDispatcher() {
        interceptors = new ArrayList<Interceptor>();
    }

    public static RentalWarningDispatcher getInstance() {
        if (instance == null)
            instance = new RentalWarningDispatcher();
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
            RentalWarningInterceptor rdi = (RentalWarningInterceptor) i;
            rdi.interceptCustomerRental(rentalContext);
        }
    }
}
