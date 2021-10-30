package oslinearregression;
import java.util.*;

public class LinearRegression {
    
    private final List<Double> x = Arrays.asList(23.0,26.0,30.0,34.0,43.0,48.0,52.0,57.0,58.0);
    private final List<Double> y = Arrays.asList(651.0,762.0,856.0,1063.0,1190.0,1298.0,1421.0,1440.0,1518.0);
    private Double b0;
    private Double b1;
    private Double sales;
    private Double advertising;
    private final Double n = Double.valueOf(x.size());
    
    
    public void LinearRegression() {
        /*Integer xSummatory = 0;
        Integer ySummatory = 0;
        List<Double> xSquared = new ArrayList<>();
        List<Double> xy = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            xSquared.add(Double.valueOf(x.get(i))* Double.valueOf(x.get(i)));
            xy.add(Double.valueOf(x.get(i))*Double.valueOf(y.get(i)));
            xSummatory += x.get(i);
            ySummatory += y.get(i);
        }
        
        Double xSquaredSummatory = 0.0;
        Double xySummatory = 0.0;
        
        for(int i=0; i<n; i++) {
            xSquaredSummatory += xSquared.get(i);
            xySummatory += xy.get(i);
        }
        
        b1 = (((n * xySummatory) - (xSummatory * ySummatory)) / ((n*xSquaredSummatory) - (xSummatory*xSummatory)));
        Double avX = (Double.valueOf(xSummatory)/Double.valueOf(n));
        Double avY = (Double.valueOf(ySummatory)/Double.valueOf(n));
        b0 = avY - (b1*avX); */
        sales = b0 + (b1* advertising);
    }
    
    public void gradientDescent() {
        b0 = 0.0;
        b1 = 0.0;
        double alpha = 0.0001;
        double mS;
        double pDB0;
        double pDb1;
        do{
            pDB0 = 0.0;
            pDb1 = 0.0;
            mS = 0.0;

            for(int i =0; i < n; i++) {
                
                pDB0 +=  (y.get(i) - (b0 + (b1 * x.get(i))));
                pDb1 += ((y.get(i) - ((b0 + (b1 * x.get(i))))) * x.get(i));
            }
            
            pDB0 *= (-2/n);
            pDb1 *= (-2/n);
            
            
            
            for(int i = 0; i < n; i++){
                mS += Math.pow((y.get(i) - (b0 + (b1*x.get(i)))),2);
            }
            mS *= (1.0/n);
            
            
            
            if(mS > 1.0 || mS < -1.0){
                b0 = b0 - (alpha * pDB0);
                b1 = b1 - (alpha * pDb1);
            }
            
        } while (mS > 1.0 || mS < -1.0);
    }
    
    public void setAdvertising(double advertising) {
        this.advertising = advertising;
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

