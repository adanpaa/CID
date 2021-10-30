package oslinearregression;
import java.util.*;

public class LinearRegression {
    
    private final List<Integer> x = Arrays.asList(2,4,6,8,10,12,14,16,18);
    private final List<Integer> y = Arrays.asList(4,8,12,16,20,24,28,32,36);
    private Double b0;
    private Double b1;
    private Double sales;
    private Double advertising;
    private Integer n;
    
    public void LinearRegression() {
        n = x.size();
        Integer xSummatory = 0;
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
        b0 = avY - (b1*avX); 
        sales = b0 + b1* advertising;
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

