package evaluations.level4.implementations;

import evaluations.level4.MyCustomizableFunction;

public class FunctionsImplementation {

    public MyCustomizableFunction square() {
        MyCustomizableFunction squareFunction = new MyCustomizableFunction() {
            @Override
            public int hash(int input) {
                int output = input * input;
                return output;
            }
        };
        return squareFunction;
    }


    public MyCustomizableFunction increment() {
        MyCustomizableFunction incrementFunction = new MyCustomizableFunction() {
            @Override
            public int hash(int input) {
                int output = input + 1;
                return output;
            }
        };
        return incrementFunction;
    }

    public MyCustomizableFunction cube() {
        MyCustomizableFunction cubeFunction = new MyCustomizableFunction() {
            @Override
            public int hash(int input) {
                int output = input * input * input;
                return output;
            }
        };
        return cubeFunction;
    }


    public MyCustomizableFunction decrement() {
        MyCustomizableFunction decrementFunction = new MyCustomizableFunction() {
            @Override
            public int hash(int input) {
                int output = input - 1;
                return output;
            }
        };
        return decrementFunction;
    }

}
