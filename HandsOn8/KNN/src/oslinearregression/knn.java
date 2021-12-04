package oslinearregression;
import java.util.*;

public class knn {
    
    private final List<Person> persons = Arrays.asList(new Person(5.0, 45.0, 77.0), new Person(5.11, 26.0, 47.0), new Person(5.6, 30.0, 55.0), new Person(5.9, 34.0, 59.0), new Person(4.8, 40.0, 72.0), new Person(5.8, 36.0, 60.0), new Person(5.3, 19.0, 40.0), new Person(5.8, 28.0, 60.0), new Person(5.5, 23.0, 45.0), new Person(5.6, 32.0, 58.0));
    private final List<Person> personsNormalized = Arrays.asList(new Person(), new Person(), new Person(), new Person(), new Person(), new Person(), new Person(), new Person(), new Person(), new Person());
    private Integer k = 2;
    private Double weight = 0.0;
    private Double height = 0.0;
    private Double age = 0.0;
    private Double minA = 100000.0;
    private Double maxA = 0.0;
    private Double minH = 100000.0;
    private Double maxH = 0.0;
    
    public void knn(Double height, Double age, Integer k) {
        this.k = k;
        this.height = height;
        this.age = age;
        
        Double sum = 0.0;
        normalizeData();
        //normalizeGivenValues();
        setDistances();
        Collections.sort(personsNormalized);
        System.out.println(k + " Puntos mas cercanos: \n");
        for(int i=0; i<k; i++){
            System.out.print(personsNormalized.get(i).getWeight() + "(");
            System.out.print(personsNormalized.get(i).getDistance() + ")\n");
            sum += personsNormalized.get(i).getWeight();
        }
        
        weight = sum/this.k;
    }
    
    public void setDistances(){
        for(int i = 0; i < 10; i++){
            personsNormalized.get(i).setDistance(euclideanD(personsNormalized.get(i).getHeight(), personsNormalized.get(i).getAge()));
        }
    }
    
    public Double euclideanD(Double height, Double age){
        return Math.sqrt((Math.pow(this.height-height, 2)+Math.pow(this.age-age, 2)));
    }
    
    public Double getWeight(){
        return weight;
    }
    
    public void calculateMinMax(){
        for(int i = 0; i < 10; i++){
            Double age = persons.get(i).getAge();
            Double height = persons.get(i).getHeight();
            if(age < minA)
                minA = age;
            if(age > maxA)
                maxA = age;
            if(height < minH)
                minH = height;
            if(age > maxH)
                maxH = height;
        }
    }
    
    public void normalizeData(){
        calculateMinMax();
        for(int i = 0; i < 10; i++){
            Person p1 = new Person();
            p1.setHeight((persons.get(i).getHeight()-minH)/(maxH-minH));
            p1.setAge((persons.get(i).getAge()-minA)/(maxA-minA));
            p1.setWeight(persons.get(i).getWeight());
            personsNormalized.set(i, p1);
        }
    }
    
    public void normalizeGivenValues(){
        for(int i = 0; i < 10; i++){
            height = ((height-minH)/(maxH-minH));
            age = ((age-minA)/(maxA-minA));
        }
    }
}

