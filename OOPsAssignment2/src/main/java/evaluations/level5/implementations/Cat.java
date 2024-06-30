package evaluations.level5.implementations;

import evaluations.level5.Animal;

public class Cat extends Animal{
    private String type;

    public Cat(String type, String name, int id) {
        super(name, id);
        this.type = type;
    }

    @Override
    public void makeSound() {
        System.out.println("Cat says meow");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
