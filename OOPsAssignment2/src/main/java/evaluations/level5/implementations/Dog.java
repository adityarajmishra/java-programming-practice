package evaluations.level5.implementations;

import evaluations.level5.Animal;

public class Dog extends Animal {
    private String breed;

    public Dog(String breed, String name, int id) {
        super(name, id);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Dog says woof");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
