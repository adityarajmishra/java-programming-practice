package section2.level2.workshop;

import section2.level2.Car;

public class Mechanical {
    public void paint(Car car){
        System.out.println("Painting: "+ car.model);
    }

    public static void addTyres(Car car){
        car.numberOfTyres += 2;
        System.out.println("Added tyres to: "+ car.model );
    }
}
