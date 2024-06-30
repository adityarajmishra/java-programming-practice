package evaluations.level11.gameobjects;

import evaluations.level11.GameObject;
import evaluations.level11.Movable;

public class SpaceShip extends GameObject implements Movable {

   private String name;
   private int fuelLevel;
   private boolean isAlive=true;

   public SpaceShip(String name, int fuelLevel, int positionX, int positionY) {
       super(positionX, positionY);
       this.name = name;
       this.fuelLevel = fuelLevel;
   }

    @Override
    public void moveDown() {
        if (this.fuelLevel > 0) {
            this.setPosition(this.getPositionX(), this.getPositionY() - 1);
            this.fuelLevel -= 1;
        }
    }
    @Override
    public void moveUp() {
        if (this.fuelLevel > 0) {
            this.setPosition(this.getPositionX(), this.getPositionY() + 1);
            this.fuelLevel -= 1;
        }
    }


    @Override
    public void moveLeft() {
        if (this.fuelLevel > 0) {
            this.setPosition(this.getPositionX() - 1, this.getPositionY());
            this.fuelLevel -= 1;
        }
    }

    @Override
    public void moveRight() {
        if (this.fuelLevel > 0) {
            this.setPosition(this.getPositionX() + 1, this.getPositionY());
            this.fuelLevel -= 1;
        }
    }

    public void displayStatus(){
        System.out.println("The fuel Level is: " + fuelLevel + " and the position is (" + this.getPositionX() + ", " + this.getPositionY() + ")");
    }
    public void refuel(int amount){
        this.fuelLevel = amount;
    }

    @Override
    public void display() {
        System.out.println("The name of the SpaceShip is: " + name + "and fuel level is: " + fuelLevel + "and it is alive: " + isAlive);
    }
}
