package evaluations.level6;

public class Lion extends CatFamily{
    public String maneColor;

    public Lion(String maneColor, int age, String location, int weight) {
        super(age, location, weight);
        this.maneColor = maneColor;
    }

    public void printManeColor(){
        System.out.println("My mane color is: "+ this.maneColor);
    }

    public void specificProperty(){
        System.out.println("Mane Color: "+this.maneColor);
    }

    public void lionProperty(){
        this.specificProperty();
        super.commonProperties();
    }
}
