package linearregression;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinearRegression object = new LinearRegression();
        Scanner sc = new Scanner(System.in);
        System.out.println("Value for x: ");
        object.setAdvertising(sc.nextInt());
        object.LinearRegression();
        System.out.println("y = B0 + B1X1");
        System.out.println("y = " + String.valueOf(object.getB0()) + 
                " + (" + String.valueOf(object.getB1()) +
                ")("+String.valueOf(object.getAdvertising()) + ")");
        System.out.println("y = " + String.valueOf(object.getSales()));
    }
}
