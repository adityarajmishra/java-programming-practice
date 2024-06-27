public class Main {

    // Complete Method to demonstrate pass by value
    public static void passByValue(int x) {
        x = x * 10;
        System.out.println("Inside passByValue method: x = " + x);
    }

    // Complete Method to demonstrate pass by reference
    public static void passByReference(Student student) {
        student.setName("John Doe");
        System.out.println("Inside passByReference method: Name = " + student.getName());
    }

    public static void main(String[] args) {
        // Demonstrate pass by value
        int num = 5;
        System.out.println("Before passByValue method: num = " + num);
        passByValue(num);
        System.out.println("After passByValue method: num = " + num);

        // Demonstrate pass by reference
        Student student = new Student("Alice");
        System.out.println("Before passByReference method: Name = " + student.getName());
        passByReference(student);
        System.out.println("After passByReference method: Name = " + student.getName());
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
