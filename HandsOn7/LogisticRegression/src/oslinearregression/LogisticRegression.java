package oslinearregression;
import java.util.*;

public class LogisticRegression {
    
    private final List<Double> x1 = Arrays.asList(1.0,1.0,1.0);
    private final List<Double> x2 = Arrays.asList(1.0,4.0,2.0);
    private final List<Double> x3 = Arrays.asList(1.0,2.0,4.0);
    private List<Double> w = Arrays.asList(0.0,0.0,0.0);
    private final Double y1 = 0.0;
    private final Double y2 = 1.0;
    private final Double y3 = 1.0;
    private final Integer iterations = 100;
    private final Double learningR = 0.1;
    
    
    public void LogisticRegression() {
        gradientDescent();
    }
        
    public void gradientDescent() {
        for(int i = 0; i < iterations; i++){
            for(int j = 0; j < 3; j++){
                w.set(j, w.get(j) - (learningR*(((calculateS(x1)-y1)*x1.get(j)) + ((calculateS(x2)-y2)*x2.get(j)) + ((calculateS(x3)-y3)*x3.get(j)))));
            }
        }
    }
    
    public Double calculateS(List<Double> a){
        return (1.0/(1.0+Math.exp(-((w.get(0))+(w.get(1)*a.get(1))+(w.get(2)*a.get(2))))));
    }
    
    public Double getw0(){
        return  w.get(0);
    }
    
    public Double getw1(){
        return w.get(1);
    }
    
    public Double getw2(){
        return w.get(2);
    }
}

