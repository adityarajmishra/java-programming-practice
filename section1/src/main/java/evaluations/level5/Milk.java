package evaluations.level5;

public class Milk extends Grocery{

    public boolean isFullCream;

    public Milk(int price, String brand, boolean isFullCream) {
        super(price, brand);
        this.isFullCream = isFullCream;
    }
}
