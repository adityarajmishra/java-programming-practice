package evaluations.level2.libraries;

import evaluations.level2.Library;

public class EastLibrary extends Library {

    private int eastCode;

    public EastLibrary(int libraryNumber, String name, int eastCode) {
        super(libraryNumber, name);
        this.eastCode = eastCode;
    }

    @Override
    public void describe() {
        System.out.println("This is East Library");
    }

    public int getEastCode() {
        return eastCode;
    }

    public void setEastCode(int eastCode) {
        this.eastCode = eastCode;
    }


}
