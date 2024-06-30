package evaluations.level6.implementations;

import evaluations.level6.Meal;
import evaluations.level6.Shape;
import evaluations.level7.Season;

public class Utility {

    public Shape methodToInvokeDrawCircle() {
        Shape circleShape = new Shape() {
            @Override
            public void draw() {
                System.out.println("Circle");
            }

            @Override
            public void about() {
                System.out.println("This is about circles");
            }
        };
        return circleShape;
    }
    public Shape methodToInvokeDrawSquare() {
        Shape squareShape = new Shape() {
            @Override
            public void draw() {
                System.out.println("Square");
            }

            @Override
            public void about() {
                System.out.println("This is about squares");
            }
        };
        return squareShape;
    }


    public Meal methodToInvokeCookDinner() {
        Meal dinnerMeal = new Meal() {
            @Override
            public void cook() {
                System.out.println("Dinner");
            }
        };
        return dinnerMeal;
    }
    public Meal methodToInvokeCookBreakfast() {
        Meal breakfastMeal = new Meal() {
            @Override
            public void cook() {
                System.out.println("Breakfast");
            }
        };
        return breakfastMeal;
    }

}
