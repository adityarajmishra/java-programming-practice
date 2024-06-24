package evaluations.level6;

public class Tiger extends CatFamily{
    public String stripePattern;

    public void printStripePattern(){
        System.out.println("My stripe pattern is: "+ this.stripePattern);
    }

    public void specificProperty(){
        System.out.println("Stripe Pattern: "+this.stripePattern);
    }

    public Tiger(String stripePattern, int age, String location, int weight) {
        super(age, location, weight);
        this.stripePattern = stripePattern;
    }

    public void tigerProperty(){
        this.specificProperty();
        super.commonProperties();
    }
}
