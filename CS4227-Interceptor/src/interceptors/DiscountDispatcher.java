package interceptors;

import java.util.ArrayList;

public class DiscountDispatcher {
    private static DiscountDispatcher instance;
    private ArrayList<Interceptor> interceptors;

    public DiscountDispatcher() {
        interceptors = new ArrayList<Interceptor>();
    }

    public static DiscountDispatcher getInstance() {
        if (instance == null)
            instance = new DiscountDispatcher();
        return instance;
    }

    public void attach(Interceptor i) {
        interceptors.add(i);
    }

    public void detach(Interceptor i) {
        interceptors.remove(i);
    }

    public void interceptDiscount(DiscountContext discountContext) {
        for (Interceptor i : interceptors) {
            DiscountInterceptor rdi = (DiscountInterceptor) i;
            rdi.interceptDiscount(discountContext);
        }
    }
}
