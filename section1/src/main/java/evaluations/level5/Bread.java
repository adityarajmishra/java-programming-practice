package evaluations.level5;

public class Bread extends Grocery{
    public boolean isExpired;

    public Bread(int price, String brand, boolean isExpired) {
        super(price, brand);
        this.isExpired = isExpired;
    }
}
