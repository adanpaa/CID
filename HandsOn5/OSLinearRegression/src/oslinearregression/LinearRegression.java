package oslinearregression;
import java.util.*;

public class LinearRegression {
    
    private final List<Double> x = Arrays.asList(23.0,26.0,30.0,34.0,43.0,48.0,52.0,57.0,58.0);
    private final List<Double> y = Arrays.asList(651.0,762.0,856.0,1063.0,1190.0,1298.0,1421.0,1440.0,1518.0);
    private Double b0 = 0.0;
    private Double b1 = 0.0;
    private Double sales;
    private Double advertising;
    private final Double n = Double.valueOf(x.size());
    
    
    public void LinearRegression() {
        sales = b0 + (b1* advertising);
    }
        
    public void gradientDescent() {
        b0 = 0.0;
        b1 = 0.0;
        double alpha = 0.0005;
         while (calculatemS() > 0.0001){
            double pDB0 = 0.0;
            double pDb1 = 0.0;
            for(int i =0; i < n; i++) {
                pDB0 +=  (y.get(i) - (b0 + b1 * x.get(i)));
                pDb1 += ((x.get(i) * (y.get(i) - (b0 + b1 * x.get(i)))));
            }
            
            pDB0 *= (-2/n);
            pDb1 *= (-2/n);
            
            b0 -= (alpha * pDB0);
            b1 -= (alpha * pDb1);
        }
    }
    
    public void setAdvertising(double advertising) {
        this.advertising = advertising;
    }
    
    public Double calculatemS() {
        double mS= 0.0;
        for(int i = 0; i < n; i++){
                mS += (y.get(i) - (b0 + (b1*x.get(i))));
            }
            return (mS*mS) * (1.0/n);
    }
    
    public Double getSales() {
        return sales;
    }
    
    public Double getAdvertising() {
        return advertising;
    }
    
    public Double getB0() {
        return b0;
    }
    
    public Double getB1() {
        return b1;
    }
}

