package evaluations.level2.libraries;

import evaluations.level2.Library;

public class WestLibrary extends Library {

    public int westCode;

    public WestLibrary(int libraryNumber, String name, int westCode) {
        super(libraryNumber, name);
        this.westCode = westCode;
    }

    @Override
    public void describe() {
        System.out.println("This is West Library");
    }



    public int getWestCode() {
        return westCode;
    }

    public void setWestCode(int westCode) {
        this.westCode = westCode;
    }
}
