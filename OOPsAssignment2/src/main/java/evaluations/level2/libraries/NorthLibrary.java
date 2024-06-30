package evaluations.level2.libraries;

import evaluations.level2.Library;

public class NorthLibrary extends Library {

    public int northCode;

    public NorthLibrary(int libraryNumber, String name, int northCode) {
        super(libraryNumber, name);
        this.northCode = northCode;
    }

    @Override
    public void describe() {
        System.out.println("This is North Library");
    }

    public int getNorthCode() {
        return northCode;
    }

    public void setNorthCode(int northCode) {
        this.northCode = northCode;
    }

}
