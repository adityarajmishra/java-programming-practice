package evaluations.level5;

public abstract class Animal {

    protected String name;
    protected int id;

    public Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract void makeSound();

    public void breath() {
        System.out.println("I am breathing");
    }


}
