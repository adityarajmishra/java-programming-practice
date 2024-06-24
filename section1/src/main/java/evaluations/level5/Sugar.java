package evaluations.level5;

public class Sugar extends Grocery{

    public boolean isCrystalized;

    public Sugar(int price, String brand, boolean isCrystalized) {
        super(price, brand);
        this.isCrystalized = isCrystalized;
    }
}
