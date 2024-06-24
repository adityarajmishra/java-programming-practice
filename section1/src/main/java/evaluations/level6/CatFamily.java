package evaluations.level6;

public class CatFamily {
    public int age;
    public String location;
    public int weight;

    public CatFamily(int age, String location, int weight) {
        this.age = age;
        this.location = location;
        this.weight = weight;
    }

    public void commonProperties(){
        System.out.println("Age: "+this.age+",Location:"+this.location+"and Weight:"+this.weight);

    }
}
