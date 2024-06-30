package evaluations.level2;

public class Library {
    protected int libraryNumber;
    protected String name;

    public Library(int libraryNumber, String name) {
        this.libraryNumber = libraryNumber;
        this.name = name;
    }

    public void printCommonData() {
        System.out.println("Name: " + this.name + ", Number: " + this.libraryNumber);
    }

    public void describe() {
        System.out.println("This is Library");
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(int libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
