/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oslinearregression;

/**
 *
 * @author User
 */
public class Person implements Comparable<Person>{
    private Double height;
    private Double age;
    private Double weight;
    private Double distance;
    
    public Person(Double height, Double age, Double weight){
        this.height = height;
        this.age = age;
        this.weight = weight;
    }
    
    public Person(){}
    
    public void setHeight(Double height){
        this.height = height;
    }
    
    public void setAge(Double age){
        this.age = age;
    }
    
    public void setWeight(Double weight){
        this.weight = weight;
    }
    
    public void setDistance(Double distance){
        this.distance = distance;
    }
    
    public Double getHeight(){
        return height;
    }
    
    public Double getAge(){
        return age;
    }
    
    public Double getWeight(){
        return weight;
    }
    
    public Double getDistance(){
        return distance;
    }

    @Override
    public int compareTo(Person o) {
        return distance.compareTo(o.getDistance());
    }
}
